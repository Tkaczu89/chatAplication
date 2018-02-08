package pl.sdacademy.javakato3.chat.server;

public class ServerMain {

    public static void main(String[] args) {
        System.out.println("Server is starting...");
        Runnable serverDispatcher = new ServerSocketDispatcher();
        System.out.println("Server runnable is created");
        new Thread(serverDispatcher).start();
        System.out.println("Waiting for connection");

    }
}
