package com.sqli.isc.iut.courses.cucumber;

public class Customer {

    private String firstName;
    private String lastName;
    private int addition;
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void inscreaseAddition(){
        this.addition += 10;
    }

    public void takeFriendAddition(Customer customer){
        this.addition += customer.addition;
    }

    public int showAddition(){
        return this.addition;
    }

    public String getLastName() {
        return lastName;
    }
}
