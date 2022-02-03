package com.examples.jgiven;

import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WhenSomeAction some_action() {
        return self();
    }
}
