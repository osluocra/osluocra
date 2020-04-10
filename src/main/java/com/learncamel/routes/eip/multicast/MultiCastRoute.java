package com.learncamel.routes.eip.multicast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true").multicast().parallelProcessing().stopOnException()
                .log("Before ${body}")
                .to("file:data/output1", "file:data/output2");

/*
        //same as above but cannot some of featureas and parallel processing
        from("file:data/input?noop=true")
                .to("file:data/output1")
                .to("file:data/output2");


 */

    }
}
