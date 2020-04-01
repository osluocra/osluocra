package com.learncamel.processor;

import org.apache.camel.Exchange;

public class CustomProcessorXstream implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        String newBody =  exchange.getIn().getBody(String.class
        );



    }
}
