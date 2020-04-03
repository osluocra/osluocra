package com.learncamel.routes.gson;

import com.learncamel.model.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {

    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:marshalGSON")
                .log("Before marshaling Object is:${body}")
                .marshal(gsonDataFormat)
                .log("Before marshaling Object is:${body}");
    }
}
