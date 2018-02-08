package pl.sdacademy.javakato3.chat.client;

import pl.sdacademy.javakato3.chat.model.ChatMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientTerminal implements Runnable {
    private final Socket socket;
    private String serverAddres = "10.0.0.6";
    private int serverPort = 5568;
    private ConsoleDelegate consoleDelegate;

    public ClientTerminal() throws IOException {
        socket = new Socket(serverAddres, serverPort);
        consoleDelegate = new ConsoleDelegate();
    }

    @Override
    public void run() {
        consoleDelegate.writeToUser("What is your nickname?: ");
        String authpr = consoleDelegate.readFromUser();
        try (ObjectOutputStream serverConnection = new ObjectOutputStream(socket.getOutputStream())) {
            ChatMessage chatMessage;
            do {
                chatMessage = new ChatMessage();
                chatMessage.setAuthor(authpr);
                chatMessage.setMessage(consoleDelegate.readFromUser());
                serverConnection.writeObject(chatMessage);
                serverConnection.flush();
            } while (!chatMessage.getMessage().equalsIgnoreCase("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
