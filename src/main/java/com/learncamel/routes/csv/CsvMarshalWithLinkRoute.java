package com.learncamel.routes.csv;

import com.learncamel.model.EmployeeWithAddress;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CsvMarshalWithLinkRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(EmployeeWithAddress.class);

        from("direct:csvObject")
                .marshal(bindy)
                .log("After marshal: ${body}")
                .to("file:data/output?fileName=file2WithAddress.txt");

    }

}
