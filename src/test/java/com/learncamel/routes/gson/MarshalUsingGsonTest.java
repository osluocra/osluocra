package com.learncamel.routes.gson;

import com.learncamel.model.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalGsonTest(){
        Employee emp = new Employee();
        emp.setName("Oscar");
        emp.setId("1234");
        emp.setHireDate("20SEP1974");
        String expected="{\"id\":\"1234\",\"name\":\"Oscar\",\"hireDate\":\"20SEP1974\"}";
        String response = template.requestBody("direct:marshalGSON", emp, String.class);

        assertEquals(expected,response);
    }

}
