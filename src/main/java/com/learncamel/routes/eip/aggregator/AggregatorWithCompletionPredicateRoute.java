package com.learncamel.routes.eip.aggregator;

import com.learncamel.aggregate.AggregatorPredicateStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorWithCompletionPredicateRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:completionPredicate")
                .log("Received message is ${body} and header id is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"),new AggregatorPredicateStrategy())
                .completionPredicate(body().contains("order-confirmed")).eagerCheckCompletion()
                .log("Final message is:${body}")
                .to("mock:output");
    }
}
