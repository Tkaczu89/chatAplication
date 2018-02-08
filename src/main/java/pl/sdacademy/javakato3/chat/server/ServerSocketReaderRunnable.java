package pl.sdacademy.javakato3.chat.server;

import pl.sdacademy.javakato3.chat.model.ChatMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerSocketReaderRunnable implements Runnable {
    private Socket clienConnection;
    private final ChatLog chatLog;


    public ServerSocketReaderRunnable(Socket clienConnection, ChatLog chatLog) {
        this.clienConnection = clienConnection;
        this.chatLog = chatLog;
        chatLog.register(clienConnection);


    }


    @Override
    public void run() {
        ChatMessage chatMessage;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(clienConnection.getInputStream())) {
            boolean clientIsConnected = true;
            while (clientIsConnected) {
                chatMessage = (ChatMessage) objectInputStream.readObject();
                if (objectInputStream.available() > 0) {
                    chatLog.acceptMessage(chatMessage);
                    clientIsConnected = true;
                    if (!chatMessage.getMessage().equalsIgnoreCase("exit")) {
                        chatLog.acceptMessage(chatMessage);
                        clientIsConnected = false;
                    }

                } else {
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
