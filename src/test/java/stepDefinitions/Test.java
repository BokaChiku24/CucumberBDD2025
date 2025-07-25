package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Test {

    @Given("User is on the NetBanking landing page")
    public void user_is_on_the_net_banking_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on the net banking landing page");
    }
    @When("User login into application")
    public void user_login_into_application() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User login into application");
    }
    @Then("Home page is displayed")
    public void home_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Home page is displayed");
    }
    @Then("Cards are displayed")
    public void cards_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Cards are displayed");

    }

    /*
    @When("User login into application with username {string} and password {string}")
    public void user_login_into_application_with_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Username: " + string + ", Password: " + string2);
    }
     */

    // Parameterization Example With Regular Expressions

    @When("^User login into application with username (.+) and password (.+)$")
    public void user_login_into_application_with_username_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Username: " + username + ", Password: " + password);
    }

    // Data Driven Testing Example

    @Given("user is on practice landing page")
    public void user_is_on_practice_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User is on the practice landing page");
    }

    @When("User signup into application")
    public void user_signup_into_application(List<String> dataTable) {
        System.out.println(dataTable.get(0));
        System.out.println(dataTable.get(1));
        System.out.println(dataTable.get(2));
        System.out.println(dataTable.get(3));
    }

    @Then("landing page is displayed")
    public void landing_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("landing page is displayed");
    }

    @Then("username and password page displayed")
    public void username_and_password_page_displayed() {
        // Write code here that turns the phrase above into concrete actions
       System.out.println("Username and password page displayed");
    }

}
