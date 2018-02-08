package pl.sdacademy.javakato3.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDispatcher implements Runnable {


    @Override
    public void run() {
        ChatLog chatLog = new ChatLog();
        try {
            ServerSocket serverSocket = new ServerSocket(5568);
            boolean serverIsUp = true;
            while (serverIsUp) {
                Socket clientConnection = serverSocket.accept();
                ServerSocketReaderRunnable socketRunnable = new ServerSocketReaderRunnable(clientConnection, chatLog);
                new Thread(socketRunnable).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
