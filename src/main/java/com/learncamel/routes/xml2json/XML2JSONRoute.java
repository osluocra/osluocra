package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;


public class XML2JSONRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:marshalEmployeexml2json")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();


        xmlJsonDataFormat.setRootName("employee");


        from("direct:unmarshalEmployeejson2xml")
        .to("log:?level=INFO&showBody=true")
                .unmarshal(xmlJsonDataFormat)//.xmljson()
        .to("log:?level=INFO&showBody=true");


    }



}
