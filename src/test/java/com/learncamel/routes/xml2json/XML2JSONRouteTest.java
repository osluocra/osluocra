package com.learncamel.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest  extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployee2JSONXML(){
        String input="<?xml version='1.0' encoding='UTF-8'?><employee><id>1234</id><name>Oscar</name><hireDate>20SEP1974</hireDate></employee>";
        String expected="{\"id\":\"1234\",\"name\":\"Oscar\",\"hireDate\":\"20SEP1974\"}";
        String response= template.requestBody("direct:marshalEmployeexml2json", input, String.class);

        //System.out.println("response:"+ response);

        assertEquals(response, expected);

    }

    @Test
    public void unmarshalEmployee2JSONXML(){
        String expected="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><hireDate>20SEP1974</hireDate><id>1234</id><name>Oscar</name></employee>\r\n";


        String input="{\"id\":\"1234\",\"name\":\"Oscar\",\"hireDate\":\"20SEP1974\"}";

        String response= template.requestBody("direct:unmarshalEmployeejson2xml", input, String.class);

        System.out.println("response:"+ response);

        assertEquals(response, expected);

    }

}
