package com.learncamel.routes.csv;

import com.learncamel.model.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {


        //DataFormat dataFormat = new BindyCsvDataFormat(Employee.class);
        // or
        DataFormat dataFormat = new BindyCsvDataFormat(new Employee().getClass());

        from("direct:objInput")
                .log("Received message is ${body}")
                .marshal(dataFormat)
                .log("Marshaled message is ${body}")
                .to("file:data/csv/output?fileName=output.txt");

    }
}
