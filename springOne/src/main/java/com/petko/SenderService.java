package com.petko;

import com.petko.entities.Message;
import com.petko.senders.ISender;

public class SenderService {
    private Message message;
    private ISender sender;

    public SenderService(Message message, ISender sender) {
        this.message = message;
        this.sender = sender;
    }

    public SenderService() {
    }

    public ISender getSender() {
        return sender;
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void sendMessage() {
        sender.send(message);
    }
}
