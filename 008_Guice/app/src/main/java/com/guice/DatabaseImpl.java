package com.guice;

public class DatabaseImpl implements Database {
    static int count;

    static {
        count = 0;
    }

    @Override
    public <T extends EntityBase> T create(T entity) {
        entity.setId(count++);
        return entity;
    }

    @Override
    public void saveChanges() {

    }
}
