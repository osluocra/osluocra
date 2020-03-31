package com.learncamel.processor;

import org.apache.camel.Exchange;

public class CustomProcessorXstream implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        String newBody = (String) exchange.getIn().getBody();


    }
}
