package com.learncamel.routes.fixedlength;

import com.learncamel.model.Address;
import com.learncamel.model.EmployeeWithFixedLengthDate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FixedLengthMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthMarshalRoute();
    }


    @Test
    public void FixedLengthMarshalTest() throws InterruptedException {
        EmployeeWithFixedLengthDate employeeWithFixedLengthDate = new EmployeeWithFixedLengthDate();


        employeeWithFixedLengthDate.setAge(20);
        employeeWithFixedLengthDate.setId("1234");
        employeeWithFixedLengthDate.setJoiningDate(LocalDate.of(2017,7,5));
        employeeWithFixedLengthDate.setName("Oscar");
        employeeWithFixedLengthDate.setRole("Software Engineer");
        employeeWithFixedLengthDate.setSalary( new BigDecimal("20000.00"));

        template.sendBody("direct:fixedLengthObject", employeeWithFixedLengthDate);


        Thread.sleep(2000);

        File myFile = new File("data/output/output_fixedlength.txt");

        assertTrue(myFile.exists());


    }
}
