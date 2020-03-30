package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }


    @Test
    public void processorDirectTest(){
        String input ="1234,Oscar,20SEP1974";
        String expectedValue ="1234:Oscar:20SEP1974";
        String output = (String) template.requestBody("direct:processorInput", input);

        assertEquals(expectedValue, output);


    }

    @Test
    public void processorDirectUsingMockTest() throws InterruptedException {
        String expectedValue="1245:Oscar:20SEP1974";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        String input="1245,Oscar,20SEP1974";

        template.sendBody("direct:processorInput",input);

        assertMockEndpointsSatisfied();


    }




}
