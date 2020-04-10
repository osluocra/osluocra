package com.learncamel.eip.wiretap;

import org.apache.camel.builder.RouteBuilder;

public class WireTapRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .wireTap("file:data/debug")
                .to("file:data/output/allwiretap");
    }
}
