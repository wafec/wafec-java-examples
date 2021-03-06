package com.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class Event {
    private long id;
    private String title;
    private Date date;

    public Event(Date date, String title) {
        this.date = date;
        this.title = title;
    }
}
