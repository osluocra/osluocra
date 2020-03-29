package com.learncamel.routes.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Before process body: ${body} and headers: ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("After process body: ${body} and headers: ${headers}")
                .to("mock:output");


    }
}
