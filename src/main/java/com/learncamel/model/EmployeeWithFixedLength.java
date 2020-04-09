package com.learncamel.model;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(ignoreTrailingChars = true)
public class EmployeeWithFixedLength {
    @DataField(pos=1, length = 4)
    private String id;

    @DataField(pos=5, length = 20, trim=true, align="L")
    private String name;

    @DataField(pos=25, length = 18)
    private String role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "EmployeeWithFixedLength{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
