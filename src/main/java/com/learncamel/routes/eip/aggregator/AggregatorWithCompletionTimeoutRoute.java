package com.learncamel.routes.eip.aggregator;

import com.learncamel.aggregate.AggregatorSimpleRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorWithCompletionTimeoutRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received Message is ${body} and the header key is: ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorSimpleRouteStrategy())
                .completionSize(3).completionTimeout(3000)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}
