package pl.sdacademy.javakato3.chat.model;

import java.util.Date;

public class DatedChatMessage extends ChatMessage {
    private Date reciveDate;


    public DatedChatMessage(ChatMessage chatMessage) {
        super(chatMessage);
        reciveDate = new Date();

    }

    public Date getReciveDate() {
        return reciveDate;
    }

    public void setReciveDate(Date reciveDate) {
        this.reciveDate = reciveDate;
    }

    @Override
    public String toString() {
        return "DatedChatMessage{" +
                "reciveDate=" + reciveDate +
                '}';
    }
}
