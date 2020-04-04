package com.learncamel.beans;

public class CamelBean {
    public String map(String input){

        return input.replace(",", "*");
    }

    public String map1(String input){
        System.out.println("Inside map1");
        return input.replace(",", "*");
    }

}
