package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public  void marshalXstreamTest() throws InterruptedException {

        String input = "123,Oscar,04JUL2017";
        String expecteOutput = "<?xml version='1.0' encoding='UTF-8'?><com.learncamel.model.Employee><id>123</id><name>Oscar</name><hireDate>04JUL2017</hireDate></com.learncamel.model.Employee>";



        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expecteOutput);

        template.sendBody("direct:cvsInput", input);

        assertMockEndpointsSatisfied();
    }

    @Test
    public  void marshalXstreamTestAlias() throws InterruptedException {

        String input = "123,Oscar,04JUL2017";
        String expecteOutput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Oscar</name><hireDate>04JUL2017</hireDate></employee>";



        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expecteOutput);

        template.sendBody("direct:cvsInput", input);

        assertMockEndpointsSatisfied();
    }

}
