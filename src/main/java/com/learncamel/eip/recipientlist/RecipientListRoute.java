package com.learncamel.eip.recipientlist;

import com.learncamel.eip.recipientlist.RecipientEIPProcessor;
import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/xmlinput?noop=true")
                .log("Before processor ${body} headers ${headers}")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientEIPProcessor())
                .recipientList(header("type"));
    }
}
