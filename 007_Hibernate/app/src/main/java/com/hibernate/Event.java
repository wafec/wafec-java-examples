package com.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Event {
    private long id;
    private String title;
    private Date date;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }
}
