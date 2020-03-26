package com.learncamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {
    @Override
    public RouteBuilder createRouteBuilder(){
        return new SampleDirectRoute();

    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        //ProducterTemplate template
        template.sendBody("direct:sampleInput", "1234,Dilip,Udemy Instructor");

        Thread.sleep(5000);

        File file = new File("data/sampleOutput");


        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);
        assertEquals("output.txt", file.listFiles()[0].getName());


        Exchange exchange = consumer.receive("file:data/sampleOutput");
        //ConsumerTemplate consumer

        //assertEquals("1234,Dilip,Udemy Instructor", exchange.getIn().getBody());
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));


    }
}
