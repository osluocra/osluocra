package com.learncamel.routes.eip.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorWithCompletionTimeoutRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithCompletionTimeoutRoute();
    }

    @Test
    public void AggregatorWithCompletionTimeoutTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");

        //it will return an array for eachAggregatorId
        List<String> lstStr = new ArrayList<String>();
        lstStr.add("12");
        lstStr.add("3");


        mockEndpoint.expectedBodiesReceived(lstStr);

        //mockEndpoint.expectedBodiesReceived("12");

        template.sendBodyAndHeader("direct:simpleAggregator","1","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",2);
        Thread.sleep(5000);
        template.sendBodyAndHeader("direct:simpleAggregator","4","aggregatorId",1);

        assertMockEndpointsSatisfied();

    }
}
