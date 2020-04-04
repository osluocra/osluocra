package com.learncamel.processor;

import com.learncamel.model.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessorXstream implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        String newBody =  exchange.getIn().getBody(String.class);

        StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
        System.out.println("newBody = " + newBody);
        Employee employee= new Employee();
        while(tokenizer.hasMoreElements()){
            employee.setId(tokenizer.nextToken());
            employee.setName(tokenizer.nextToken());
            employee.setHireDate(tokenizer.nextToken());
        }

        System.out.println("employee = " + employee);
        exchange.getIn().setBody(employee);






    }
}
