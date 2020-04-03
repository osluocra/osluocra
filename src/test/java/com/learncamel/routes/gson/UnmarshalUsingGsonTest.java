package com.learncamel.routes.gson;

import com.learncamel.model.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingGson();
    }

    @Test
    public void UnmarshalUsingGsonTest(){

        Employee emp = new Employee();
        emp.setName("Oscar");
        emp.setId("1234");
        emp.setHireDate("20SEP1974");

        String input="{\"id\":\"1234\",\"name\":\"Oscar\",\"hireDate\":\"20SEP1974\"}";
        Employee response = template.requestBody("direct:unmarshalGson",input, Employee.class);

        assertEquals(emp.toString(),response.toString());

    }
}
