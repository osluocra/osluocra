package com.learncamel.routes.eip.multicast;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MultiCastRoute();
    }

    @Test
    public void MultiCastTest() throws InterruptedException {
        Thread.sleep(5000);

        File dir1 = new File("data/output1");
        File dir2 = new File("data/output2");

        assertTrue(dir1.exists());
        assertTrue(dir2.exists());

    }
}
