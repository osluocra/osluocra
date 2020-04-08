package com.learncamel.routes.fixedlength;

import com.learncamel.model.EmployeeWithFixedLength;
import com.learncamel.model.EmployeeWithFixedLengthDate;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnmarshalDateRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthDateUnmarshalRoute();
    }
    @Test
    public void FixedLengthUnmarshalTest(){

        Exchange exchange = consumer.receive("direct:output");

        List<EmployeeWithFixedLengthDate> lstEmployees = (List<EmployeeWithFixedLengthDate>) exchange.getIn().getBody();

        LocalDate oscarHiredDate  = LocalDate.of(2017, 7, 5);

        LocalDate juanyHiredDate = LocalDate.of(2018, 4, 28);

        assertEquals(oscarHiredDate, lstEmployees.get(0).getJoiningDate());
        assertEquals(juanyHiredDate, lstEmployees.get(1).getJoiningDate());



    }


}
