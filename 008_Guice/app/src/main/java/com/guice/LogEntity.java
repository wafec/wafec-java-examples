package com.guice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LogEntity extends EntityBase {
    private String message;

    public LogEntity(String message) {
        this.message = message;
    }
}
