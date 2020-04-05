package com.learncamel.routes.csv;

import com.learncamel.model.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVUnMarshalRoute  extends RouteBuilder {


    public void configure() throws Exception {
        Employee emp = new Employee();

        DataFormat bindy = new BindyCsvDataFormat(emp.getClass());
        from("file:data/csv/input?fileName=file1.txt&noop=true")
                .unmarshal(bindy)
                .log("UnMarshalled Message: ${body}")
                .to("direct:output");
    }
}
