package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.Arrays;

public class CopyFilesCamel {

    public static void main(String[] args) {
        int iSleepTime=5000;
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });


            context.start();

            Thread.sleep(iSleepTime);


            context.stop();

        } catch (Exception e) {
            System.out.println("Error is: " + e);
            e.printStackTrace();
        }


    }
}
