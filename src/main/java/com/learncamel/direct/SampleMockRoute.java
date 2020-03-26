package com.learncamel.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:data/sampleInput")
                .log("Received Message is ${body} and Headers are ${headers}")
                .to("mock:output");

    }
}
