package com.examples.jgiven;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class MyShinyJGivenTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Test
    public void something_should_happen() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }
}
