package com.learncamel.processor.exceptions;

import org.apache.camel.Exchange;

public class ExceptionProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);

        System.out.println("Acutal Exception Message->" + e.getMessage());
        System.out.println("Acutal Exception Class ->" + e.getClass());

        String failedEndpoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint:" + failedEndpoint);
        exchange.getIn().setBody("Exception happend in the route.");

    }
}
