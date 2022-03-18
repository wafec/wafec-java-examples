package com.hibernate;

import java.util.Date;

public interface EventService {
    void registerEvent(Date date, String title);
}
