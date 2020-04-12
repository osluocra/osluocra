package com.learncamel.routes.eip.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorWithCompletionPredicateRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithCompletionPredicateRoute();
    }

    @Test
    public void AggregatorWithCompletionPredicateTest() throws InterruptedException {

        String orderCreate="12345,samsung-phone,order-created";
        String orderConfirm="12345,samsung-phone,order-confirmed";
        String header="aggregatorId";
        int headerValue=12345;
        String endpointUri="direct:completionPredicate";

        String expectedValue = orderCreate.concat(":").concat(orderConfirm);

        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(expectedValue);
        template.sendBodyAndHeader(endpointUri,orderCreate, header ,headerValue);

        Thread.sleep(10000);
        template.sendBodyAndHeader(endpointUri, orderConfirm, header, headerValue);

        assertMockEndpointsSatisfied();



    }
}
