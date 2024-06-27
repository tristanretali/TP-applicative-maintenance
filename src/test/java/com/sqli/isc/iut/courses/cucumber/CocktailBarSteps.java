package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ParameterType;

public class CocktailBarSteps {
    private CocktailBar cocktailBar;
    private boolean result;
    private Customer mrLeblanc;
    private Customer mrPignon;

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

    @When("I add Mr Pignon and Mr Leblanc")
    public void iAddMrPignonAndMrLeblanc() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Pignon"));
        customers.add(new Customer("John", "Leblanc"));
        cocktailBar.addCustomer(customers);
    }

    @And("Each of them buy one cocktail of the month")
    public void eachOfThemBuyCocktailOfTheMonth() {
        mrPignon = cocktailBar.findCustomerByLastName("Pignon");
        mrLeblanc = cocktailBar.findCustomerByLastName("Leblanc");
        mrPignon.inscreaseAddition();
        mrLeblanc.inscreaseAddition();

    }

    @And("Mr Leblanc paid for his friend")
    public void ofThemPaidForHisFriend() {
        mrLeblanc.takeFriendAddition(mrPignon);
    }

    @Then("The result is {int}")
    public void theResultIs(int arg0) {
        assertEquals(arg0, mrLeblanc.showAddition());
    }

    @And("Mr Pignon pay his addition of {int}")
    public void mrPignonPayHisAdditionOf(int arg0) {
        assertEquals(arg0, mrPignon.showAddition());
    }

    @And("Mr Leblanc buy {int} other cocktail of the month")
    public void mrLeblancBuyTwoOtherCocktailOfTheMonth(int args0) {
        for (int i = 0; i < args0; i++) {
            mrLeblanc.inscreaseAddition();
        }
    }

    @Then("The addition of Mr Leblanc is {int}")
    public void theAdditionOfMrLeblancIs(int arg0) {
        assertEquals(arg0, mrLeblanc.showAddition());
    }
}
