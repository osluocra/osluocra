package com.learncamel.processor;

import org.apache.camel.Exchange;

public class InsertProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);
        System.out.println("Input to be persisted:" + input);

        String insertQuery = "INSERT INTO messages values ('1','" + input + "')";
        System.out.println("Insert Query is: " + insertQuery);
        exchange.getIn().setBody(insertQuery);
    }
}
