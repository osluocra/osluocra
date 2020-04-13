package com.learncamel.routes.eip.contentbasedrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBaseRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBaseRoute();
    }

    @Test
    public void ContentBaseRouteTest() throws InterruptedException {
        Thread.sleep(5000);

        File html = new File("data/output/html");
        File txt = new File("data/output/txt");
        File json = new File("data/output/json");
        File other = new File("data/output/other");
        File all = new File("data/output/all");

        assertTrue(html.isDirectory());
        assertTrue(json.isDirectory());
        assertTrue(txt.isDirectory());
        assertTrue(other.isDirectory());
        assertTrue(all.isDirectory());

    }
}
