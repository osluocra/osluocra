package com.learncamel.routes.csv;

import com.learncamel.model.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CSVUnMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnMarshalRoute();
    }

    @Test
    public void CSVUnMarshalTest() throws InterruptedException {
        System.out.println("Before exchange");

        Exchange exchange = consumer.receive("direct:output");

        System.out.println("Before sleep");

        Thread.sleep(1000);
        System.out.println("Before getbody");
        List<Employee> employeeList = (List<Employee>) exchange.getIn().getBody();

        assertEquals("Oscar", employeeList.get(0).getFirstName());
        assertEquals("Eliana", employeeList.get(1).getFirstName());
    }
}
