package com.learncamel.routes.eip.aggregator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregatorWithGroupExchangedRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:grpAggregator")
                .log("Received message is ${body} and headers is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .log("Aggregated messages is ${body}")
                .to("mock:output");

    }
}
