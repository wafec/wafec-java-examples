package com.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private long id;
    private String text;
    private Event event;

    public Message(String text, Event event) {
        this.text = text;
        this.event = event;
    }
}
