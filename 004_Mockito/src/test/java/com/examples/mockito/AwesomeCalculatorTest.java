package com.examples.mockito;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AwesomeCalculatorTest {
    private IAwesomeSummandStringParser summandParser;

    @Before
    public void setUp() {
        this.summandParser = mock(IAwesomeSummandStringParser.class);
    }

    @Test
    public void evaluatesExpression() {
        when(this.summandParser.parse(anyString())).thenReturn(new String[] { "1", "2", "3" });
        IAwesomeCalculator sut = this.getSut();

        int result = sut.evaluate("1+2+3");

        assertEquals(6, result);
    }

    private IAwesomeCalculator getSut() {
        return new AwesomeCalculator(summandParser);
    }
}
