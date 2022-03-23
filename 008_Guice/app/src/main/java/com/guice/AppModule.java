package com.guice;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    public AppModule() {

    }

    @Override
    protected void configure() {
        bind(Database.class).to(DatabaseImpl.class);
        bind(Foo.class).to(FooImpl.class);
    }
}
