package pl.sdacademy.javakato3.chat.server;

import pl.sdacademy.javakato3.chat.model.ChatMessage;
import pl.sdacademy.javakato3.chat.model.DatedChatMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ChatLog {
    private List<Socket> observers = new ArrayList<>();

    public void register(Socket socket) {
        observers.add(socket);
    }

    public void unreister(Socket socket) {
        observers.remove(socket);
    }

    public void notifyObservers(DatedChatMessage message) {

        for (Socket observer : observers) {
            try {
                OutputStream outputStream = observer.getOutputStream();
                ObjectOutputStream clientConnection = new ObjectOutputStream(outputStream);
                clientConnection.writeObject(message);
                clientConnection.flush();
            } catch (IOException e) {
                System.out.println("Cannot send message to one of the clients!");
            }
        }
    }

    public void acceptMessage(ChatMessage message) {
        DatedChatMessage datedChatMessage = new DatedChatMessage(message);
        displayMessage(datedChatMessage);
        notifyObservers(datedChatMessage);

    }

    private void displayMessage(DatedChatMessage datedChatMessage) {
        StringJoiner messageJoiner = new StringJoiner(" ", ">", "");
        messageJoiner.add(datedChatMessage.getReciveDate().toString());
        messageJoiner.add(datedChatMessage.getAuthor() + ":");
        messageJoiner.add(datedChatMessage.getMessage());
        System.out.println(messageJoiner);

    }

}
