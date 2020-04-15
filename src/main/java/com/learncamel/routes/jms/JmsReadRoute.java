package com.learncamel.routes.jms;

import org.apache.camel.builder.RouteBuilder;

public class JmsReadRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:queue:testQueue")
                .log("Body is: ${body}")
                .to("log:?level=INFO&showBody=true")
                .to("direct:readQueue");
    }
}
