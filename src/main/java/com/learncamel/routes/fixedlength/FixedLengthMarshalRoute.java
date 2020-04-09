package com.learncamel.routes.fixedlength;

import com.learncamel.model.EmployeeWithFixedLengthDate;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthMarshalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLengthDate.class);

        from("direct:fixedLengthObject")
                .log("Before marshaling ${body}")
                .marshal(bindy)
                .log("After marshaling ${body}")
                .to("file:data/output?fileName=output_fixedlength.txt");




    }
}
