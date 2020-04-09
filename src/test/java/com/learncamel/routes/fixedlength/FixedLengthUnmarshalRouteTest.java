package com.learncamel.routes.fixedlength;

import com.learncamel.model.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class FixedLengthUnmarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnmarshalRoute();
    }
    @Test
    public void FixedLengthUnmarshalTest(){

        Exchange exchange = consumer.receive("direct:output");




        List<EmployeeWithFixedLength> lstEmployeeWithFixedLength = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();

        assertNotNull(lstEmployeeWithFixedLength);
        System.out.println("employeeWithFixedLength" + lstEmployeeWithFixedLength.get(0));

        //expecting 2 records
        assertEquals(2, lstEmployeeWithFixedLength.size());

        assertEquals("OSCAR OCHOA", lstEmployeeWithFixedLength.get(0).getName());
        assertEquals("JUANA LARA", lstEmployeeWithFixedLength.get(1).getName());

    }


}
