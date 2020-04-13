package com.learncamel.routes.eip.recipientlist;

import org.apache.camel.Exchange;

public class RecipientEIPProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String employeeType = exchange.getIn().getHeader("type", String.class);
        final String BASE_DIR="data/output/";

        if(employeeType.equalsIgnoreCase("senior")){
            exchange.getIn().setHeader("type", "file:" + BASE_DIR + "xmlsenior");
        }else if(employeeType.equalsIgnoreCase("junior")){
            exchange.getIn().setHeader("type", "file:" + BASE_DIR + "xmljunior");

        }else {
            exchange.getIn().setHeader("type", "file:" + BASE_DIR + "xmldiscarted");
        }

    }
}
