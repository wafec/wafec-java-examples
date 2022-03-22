package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.function.Consumer;

public final class DatabaseUtils {
    private DatabaseUtils() {

    }

    static public void executeQueryOnTransaction(Consumer<Session> consumer) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        consumer.accept(session);
        session.getTransaction().commit();
        session.close();
    }

    static public SessionFactory getSessionFactory() {
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
