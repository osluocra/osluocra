package com.learncamel.routes.gson;

import com.learncamel.model.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnmarshalUsingGson extends RouteBuilder {
    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);



        from("direct:unmarshalGson")
                .log("Before unmarshaling: ${body}")
                .unmarshal(gsonDataFormat)
                .log("After unmarshaling: ${body}");
    }
}
