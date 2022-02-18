package com.iv1201.client.model;

/**
 *
 * @author leohj
 */
public class Person {
    private final String name;
    private final String token;
    private final String role;

    
    public Person(String name, String token, String role) {
        this.name = name;
        this.token = token;
        this.role = role;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getRole(){
        return this.role;
    }
}
