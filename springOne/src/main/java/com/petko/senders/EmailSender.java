package com.petko.senders;

import com.petko.entities.Message;

public class EmailSender implements ISender{
    private String details;

    public EmailSender(String details) {
        this.details = details;
    }

    public EmailSender() {
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public void send(Message message) {
        System.out.println("message title: '" + message.getTitle() + "', message body: '" + message.getBody() + "'.");
    }
}
