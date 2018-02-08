package pl.sdacademy.javakato3.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDelegate {
    public String readFromUser() {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return inputReader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void writeToUser(String message) {
        System.out.println(message);
    }
}
