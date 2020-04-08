package com.learncamel.routes.csv;

import com.learncamel.model.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CsvUnMarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvUnMarshalWithLinkRoute();
    }

    @Test
    public void CsvUnMarshalWithLinkTest() throws InterruptedException {

        Exchange exchange = consumer.receive("direct:output");

        Thread.sleep(2000);

        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();
        System.out.println(employeeWithAddress);

        assertEquals("USA", employeeWithAddress.getAddress().getCountry());


    }
}
