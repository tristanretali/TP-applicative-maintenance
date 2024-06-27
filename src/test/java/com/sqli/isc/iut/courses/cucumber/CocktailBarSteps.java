package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ParameterType;

public class CocktailBarSteps {
    private CocktailBar cocktailBar;
    private boolean result; 

    @ParameterType("true|false")
    public boolean bool(String value) {
        return Boolean.parseBoolean(value);
    }

    @Given("a new cocktail bar")
    public void Setup(){
        cocktailBar = new CocktailBar();
    }

    @Given("There is {int} people")
    public void initalizeCustomers(int numberOfCustomers){
        for (int i = 0; i < numberOfCustomers; i++) {
            cocktailBar.customers.add(new Customer("John", "Doe"));
        }
    }

    @When("I add {int} people")
    public void add(int numberOfCustomers){
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(new Customer("John", "Doe"));
        }
        result = cocktailBar.addCustomer(customers);
    }

    @Then("The result is {bool}")
    public void the_result_is(boolean expected){
        assertEquals(expected, result);
    }
}
