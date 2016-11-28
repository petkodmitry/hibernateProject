package com.petko.senders;

import com.petko.entities.Message;

public interface ISender {
    void send(Message message);
}
