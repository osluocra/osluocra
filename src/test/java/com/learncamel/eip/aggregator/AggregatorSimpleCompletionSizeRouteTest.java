package com.learncamel.eip.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorSimpleCompletionSizeRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorSimpleCompletionSizeRoute();

    }


    @Test
    public void aggregatorSimpleTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        assertMockEndpointsSatisfied();
    }















    @Test
    public void aggregatorMultipleMessagesTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");

        List<String> lstString = new ArrayList<String>();
        lstString.add("123");
        lstString.add("567");
        mockEndpoint.expectedBodiesReceived(lstString);


        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "5", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "6", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "7", "aggregatorId", 1);
        assertMockEndpointsSatisfied();

    }


    @Test
    public void aggregatorMultipleMessagesDifferentAggregatorId() throws InterruptedException {

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        List<String> lstArray = new ArrayList<String>();
        lstArray.add("123");
        lstArray.add("555");

        mockEndpoint.expectedBodiesReceived(lstArray);
        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","2","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","3","aggregatorId",1);
        template.sendBodyAndHeader("direct:simpleAggregator","5","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","5","aggregatorId",2);
        template.sendBodyAndHeader("direct:simpleAggregator","5","aggregatorId",2);

        assertMockEndpointsSatisfied();
    }



























}
