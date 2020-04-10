package com.learncamel.eip.aggregator;

import org.apache.camel.builder.RouteBuilder;

public class AggregatorSimpleCompletionSizeRoute  extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received message is ${body} and key{header.aggregatorId")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy()).completionSize(3)
                .log("Aggregated message is ${body} and key{header.aggregatorId}")
                .to("mock:output");

    }
}
