package com.learncamel.routes.fixedlength;

import com.learncamel.model.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthUnmarshalRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bingy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);

        from("file:data/csv/input?fileName=fixedlength.txt&noop=true")
                .log("Before Unmarshaling ${body}")
                .unmarshal(bingy)
                .log("Afer marshal ${body}")
                .to("direct:output");




    }
}
