package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest  extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute() ;
    }


    @Test
    public void testBean(){
      String input="1234,Oscar,20SEP1974";
      String expected="1234*Oscar*20SEP1974";

      String output = (String)template.requestBody("direct:beanInput", input);

      assertEquals(output,expected);

    }

    @Test
    public void testBeanMock() throws InterruptedException {
        String input="1234,Oscar,20SEP1974";
        String expected="1234*Oscar*20SEP1974";

        MockEndpoint mock = getMockEndpoint("mock:output");

        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:beanInput", input);

        assertMockEndpointsSatisfied();



    }
}
