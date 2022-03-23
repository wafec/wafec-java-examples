package com.guice;

public interface Database {
    <T extends EntityBase> T create(T entity);
    void saveChanges();
}
