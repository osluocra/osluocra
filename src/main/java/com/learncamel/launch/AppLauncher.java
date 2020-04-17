package com.learncamel.launch;

import com.learncamel.routes.jms2jdbc.Jms2DBRoute;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class AppLauncher {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        String url="jdbc:postgresql://localhost:5432/localDB";
        main.bind("myDataSource", setupDataSource(url));

        main.addRouteBuilder(new Jms2DBRoute());

        System.out.println("Starting Camel JMS to DB Route");
        main.run();

    }

    private static DataSource setupDataSource(String url) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("osluocra");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("");
        ds.setUrl(url);

        return ds;
    }
}
