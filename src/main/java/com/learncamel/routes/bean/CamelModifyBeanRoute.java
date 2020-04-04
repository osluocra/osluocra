package com.learncamel.routes.bean;

import com.learncamel.beans.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean is: ${body}")
                //.bean(new CamelBean()) //default method in bean is map
                .bean(new CamelBean(),"map1")
                .log("After bean is: ${body}")
                .to("mock:output");
    }
}
