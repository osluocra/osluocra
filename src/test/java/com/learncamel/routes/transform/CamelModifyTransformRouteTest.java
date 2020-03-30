package com.learncamel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }


    @Test
    public vod testTransform(){
        String input="1234,OSCAR,20SEP1974";

    }

}
