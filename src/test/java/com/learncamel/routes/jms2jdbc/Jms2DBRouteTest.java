package com.learncamel.routes.jms2jdbc;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

public class Jms2DBRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new Jms2DBRoute();
    }


    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url="jdbc:postgresql://localhost:5432/localDB";


        DataSource datasource = setupDataSource(url);
        SimpleRegistry registry= new SimpleRegistry();

        registry.put("myDataSource", datasource);

        CamelContext context = new DefaultCamelContext(registry);

        return context;
    }









    private DataSource setupDataSource(String url) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("osluocra");
        ds.setDriverClassName("org.postgresql.Driver");

        ds.setPassword("");
        ds.setUrl(url);

        return ds;
    }

    @Test
    public void jms2DBRouteTest(){
        ArrayList responseList = (ArrayList) consumer.receiveBody("direct:output");
        System.out.println("responseList:" + responseList.size());
        assertNotEquals(0, responseList.size());
    }
}
