package com.learncamel.routes;

import com.learncamel.routes.process.CamelModifyFileProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelFileExampleProcessorTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expectedValue="1234:OSCAR:20SEP1974\n" +
                "5678:JUANY:02SEP1969\n";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();

    }
}
