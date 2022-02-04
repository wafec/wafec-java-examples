package com.examples.mockito;


public class AwesomeCalculator implements IAwesomeCalculator {
    private IAwesomeSummandStringParser summandParser;

    public AwesomeCalculator(IAwesomeSummandStringParser summandParser) {
        this.summandParser = summandParser;
    }

    public int evaluate(String expression) {
        int sum = 0;
        for (String summand : this.summandParser.parse(expression))
            sum += Integer.valueOf(summand);
        return sum;
    }
}