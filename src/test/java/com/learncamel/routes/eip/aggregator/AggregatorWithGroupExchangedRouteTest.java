package com.learncamel.routes.eip.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class AggregatorWithGroupExchangedRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorWithGroupExchangedRoute();
    }

    @Test
    public void AggregatorWithGroupExchangedTest() throws InterruptedException {
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedMessageCount(1);
        String endpointUri="direct:grpAggregator";
        String header="aggregatorId";



        template.sendBodyAndHeader(endpointUri,"1", header, 1);
        template.sendBodyAndHeader(endpointUri,"2", header, 1);
        template.sendBodyAndHeader(endpointUri, "3", header, 1);

        assertMockEndpointsSatisfied();

        Exchange exchangeList = mockEndpoint.getExchanges().get(0);

        List<Exchange> exchangeList1 = (List<Exchange>) exchangeList.getProperty(Exchange.GROUPED_EXCHANGE);

        for(Exchange exchange : exchangeList1){
            System.out.println("Exchange Body is:" + exchange.getIn().getBody());
        }

    }

}
