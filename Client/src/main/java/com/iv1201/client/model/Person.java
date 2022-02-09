package com.iv1201.client.model;

/**
 *
 * @author leohj
 */
public class Person {
    private final int id;
    private final String name;
    private final String surname;
    private final String pnr;
    private final String email;
    private final String password;
    private final String role;
    private final String username;

    
    public Person(int id, String name, String surname, String pnr, String email, String password, String role, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pnr = pnr;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public String getPnr(){
        return this.pnr;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public String getUsername(){
        return this.username;
    }
}
