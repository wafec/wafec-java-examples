package com.hibernate;

import java.util.Date;
import java.util.List;

public interface EventService {
    void registerEvent(Date date, String title);

    List<Event> retrieveAllEvents();
}
