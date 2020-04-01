package com.learncamel.routes.xmlxstream;

import com.learncamel.model.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingXstreamTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingXstream();
    }

    @Test
    public void unMarshalTest() throws InterruptedException {
        Employee employee = new Employee();
        employee.setId("1234");
        employee.setName("Oscar");
        employee.setHireDate("20SEP1974");

        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>1234</id><name>Oscar</name><hireDate>20SEP1974</hireDate></employee>";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(employee.toString());
        template.sendBody("direct:xmlInput",input);

        assertMockEndpointsSatisfied();



    }
}
