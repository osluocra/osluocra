package com.learncamel.routes.xmlxstream;

import com.learncamel.processor.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;

public class MarshalUsingXstream extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:xstreamInput")
                .process(new CustomProcessorXstream())
                .to("mock:output");


    }
}
