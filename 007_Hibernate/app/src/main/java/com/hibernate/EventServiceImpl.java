package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class EventServiceImpl implements  EventService {
    @Override
    public void registerEvent(Date date, String title) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Event(date, title));
        session.getTransaction().commit();
        session.close();
    }

    private SessionFactory getSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }
}
