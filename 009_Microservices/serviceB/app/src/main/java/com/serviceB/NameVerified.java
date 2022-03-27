package com.serviceB;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NameVerified {
    private String name;
    private boolean isValid;
}
