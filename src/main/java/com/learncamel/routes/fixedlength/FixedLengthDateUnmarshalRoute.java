package com.learncamel.routes.fixedlength;

import com.learncamel.model.EmployeeWithFixedLength;
import com.learncamel.model.EmployeeWithFixedLengthDate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthDateUnmarshalRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bingy = new BindyFixedLengthDataFormat(EmployeeWithFixedLengthDate.class);

        from("file:data/csv/input?fileName=fixedlength-date.txt&noop=true")
                .log("Before Unmarshaling ${body}")
                .unmarshal(bingy)
                .log("Afer marshal ${body}")
                .to("direct:output");




    }
}
