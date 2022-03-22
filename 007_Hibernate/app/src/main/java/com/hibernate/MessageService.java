package com.hibernate;

import java.util.List;

public interface MessageService {
    void registerMessage(String text, Event event);
    List<Message> retrieveAllMessages();
}
