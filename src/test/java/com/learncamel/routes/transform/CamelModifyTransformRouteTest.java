package com.learncamel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }


    @Test
    public void testTransform(){
        String input="1234,OSCAR,20SEP1974";

        String expected="1234*OSCAR*20SEP1974";

        String output = (String)template.requestBody("direct:transformInput", input);


        assertEquals(expected, output);


    }

    @Test
    public void testTransformMock() throws InterruptedException {
        String input="1234,OSCAR,20SEP1974";

        String expected="1234*OSCAR*20SEP1974";

        MockEndpoint mock = getMockEndpoint("mock:output");

        mock.expectedBodiesReceived(expected);

        template.sendBody(input);

        assertMockEndpointsSatisfied();




    }

}
