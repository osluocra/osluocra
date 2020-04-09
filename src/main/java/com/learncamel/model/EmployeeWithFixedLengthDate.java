package com.learncamel.model;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

import java.math.BigDecimal;
import java.time.LocalDate;

@FixedLengthRecord
public class EmployeeWithFixedLengthDate {

    @DataField(pos=1, length = 4)
    private String id;

    @DataField(pos=5, length = 20, trim=true, align="L")
    private String name;

    @DataField(pos=25, length = 17, trim=true, align="L")
    private String role;

    @DataField(pos=42,length=9,pattern = "ddMMMyyyy")
    private LocalDate joiningDate;


    @DataField(pos=51, delimiter = "^")
    private int age;

    @DataField(pos=54, length =6, precision = 2)
    private BigDecimal salary;


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeWithFixedLengthDate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", joiningDate=" + joiningDate +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

}
