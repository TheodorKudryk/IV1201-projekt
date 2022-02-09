package com.iv1201.client.model;

/**
 *
 * @author leohj
 */
public class Person {
    private final int id;
    private final String name;
    private final String role;

    
    public Person(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    
    public String getRole(){
        return this.role;
    }
}
