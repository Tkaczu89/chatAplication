package pl.sdacademy.javakato3.chat.client;

import java.io.IOException;

public class ClientTerminalMain {
    public static void main(String[] args) throws IOException {
        Runnable clientTerminal = new ClientTerminal();
        Thread clientThread = new Thread(clientTerminal);
        clientThread.start();
    }
}
