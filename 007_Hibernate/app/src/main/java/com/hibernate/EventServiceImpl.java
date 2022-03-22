package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class EventServiceImpl implements  EventService {
    @Override
    public void registerEvent(final Date date, final String title) {
        DatabaseUtils.executeQueryOnTransaction((session) -> {
            session.save(new Event(date, title));
        });
    }

    @Override
    public List<Event> retrieveAllEvents() {
        final List<Event> result = new ArrayList<>();
        DatabaseUtils.executeQueryOnTransaction((session -> {
            Query query = session.createQuery("FROM Event");
            result.addAll(query.list());
        }));
        return result;
    }


}
