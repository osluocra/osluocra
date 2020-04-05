package com.learncamel.routes.csv;

import com.learncamel.model.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVMarshalRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void CSVMarshalTest(){
        Employee emp1 = new Employee("1234","Pachito","Oscar", "Ochoa");
        Employee emp2 = new Employee("4636","Dad","Oscar", "Ochoa Ramon");


        List<Employee> emplList = new ArrayList<Employee>();

        emplList.add(emp1);
        emplList.add(emp2);

        template.sendBody("direct:objInput", emplList);



        File file = new File("data/csv/output");


        assertTrue(file.isDirectory());



    }

}


