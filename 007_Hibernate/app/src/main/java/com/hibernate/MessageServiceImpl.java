package com.hibernate;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Override
    public void registerMessage(final String text, final Event event) {
        DatabaseUtils.executeQueryOnTransaction((session -> {
            session.save(new Message(text, event));
        }));
    }

    @Override
    public List<Message> retrieveAllMessages() {
        List<Message> result = new ArrayList<>();
        DatabaseUtils.executeQueryOnTransaction((session -> {
            Query query = session.<Message>createQuery("FROM Message msg JOIN FETCH msg.event ev");
            result.addAll(query.list());
        }));
        return result;
    }
}
