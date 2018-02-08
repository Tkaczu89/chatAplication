package pl.sdacademy.javakato3.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable{
    public static final long serialVersionUID =1L;
    private String author;
    private String message;

    public ChatMessage() {
    }

    public ChatMessage(ChatMessage origin) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
