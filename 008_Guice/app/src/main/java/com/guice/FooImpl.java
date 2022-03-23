package com.guice;

import com.google.common.base.Strings;
import com.google.inject.Inject;

public class FooImpl implements Foo {
    private Database database;

    @Inject
    public FooImpl(Database database) {
        this.database = database;
    }

    @Override
    public void hello(String name) {
        String message = String.format("Hello %s!%n", Strings.isNullOrEmpty(name) ? "world" : name);
        LogEntity log = this.database.create(new LogEntity(message));
        System.out.println(log.toString());
        this.database.saveChanges();
    }
}
