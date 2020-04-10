package com.learncamel.eip.recipientlist;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RecipientListRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RecipientListRoute();
    }

    @Test
    public void RecipientListTest() throws InterruptedException {
        Thread.sleep(5000);

    }
}
