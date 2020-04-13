package com.learncamel.routes.eip.wiretap;

import com.learncamel.routes.eip.wiretap.WireTapRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class WireTapRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WireTapRoute();
    }

    @Test
    public void WireTapTest() throws InterruptedException {
        Thread.sleep(5000);

        File outputDir = new File("data/output/allwiretap");

        File debugDir = new File ("data/debug");


        assertTrue(outputDir.exists());

        assertTrue(debugDir.exists());
    }


}
