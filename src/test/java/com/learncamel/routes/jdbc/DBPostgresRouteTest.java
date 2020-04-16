package com.learncamel.routes.jdbc;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;


public class DBPostgresRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DBPostgresRoute();
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        String url="jdbc:postgresql://localhost:5432/localDB";
        DataSource dataSource = setupDataSource(url);

        SimpleRegistry registry = new SimpleRegistry();

        registry.put("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(registry);

        return context;


    }

    private DataSource setupDataSource(String url) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("osluocra");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("");
        ds.setUrl(url);
        return  ds;
    }

    @Test
    public void insertData(){
        String input = "first db input3";

        ArrayList responseList = template.requestBody("direct:dbInput", input, ArrayList.class);

        System.out.println("responseList size: " + responseList.size());
        assertNotEquals(0, responseList.size());


    }
}
