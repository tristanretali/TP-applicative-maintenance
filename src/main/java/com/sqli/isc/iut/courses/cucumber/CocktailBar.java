package com.sqli.isc.iut.courses.cucumber;

import java.util.ArrayList;

public class CocktailBar {
    
    public ArrayList<Customer> customers = new ArrayList<>();

    public boolean addCustomer(ArrayList<Customer> customer) {
        if(checkNumberOfCustomer(customer)) {
            customers.addAll(customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNumberOfCustomer(ArrayList<Customer> customer) {
        if (customers.size()+customer.size() > 10) {
            return false;
        } else {
            return true;
        }
    }

    public Customer findCustomerByLastName(String lastName) {
        for (Customer customer : customers) {
            if(customer.getLastName().equals(lastName)) {
                return customer;
            }
        }
        return null;
    }

}
