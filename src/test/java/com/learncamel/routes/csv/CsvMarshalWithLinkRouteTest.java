package com.learncamel.routes.csv;

import com.learncamel.model.Address;
import com.learncamel.model.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CsvMarshalWithLinkRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CsvMarshalWithLinkRoute();
    }

    @Test
    public void CsvMarshalWithLinkTest(){
        Address myAddress = new Address();
        myAddress.setAddressLine("6264 Old Mill Ct");
        myAddress.setCity("Hamilton");
        myAddress.setCountry("USA");
        myAddress.setState("OH");
        myAddress.setZipcode("75014");

        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress();
        employeeWithAddress.setAddress(myAddress);
        employeeWithAddress.setFirstName("Oscar");
        employeeWithAddress.setLastName("Ochoa");
        employeeWithAddress.setId("1234");

        template.sendBody("direct:csvObject", employeeWithAddress);

        File myFile = new File("data/output/file2WithAddress.txt");

        assertTrue(myFile.exists());



    }
}
