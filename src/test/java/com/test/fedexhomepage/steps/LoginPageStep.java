package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageStep {

    private final HeaderStep headerStep;

    private LoginPage loginPage;

    public LoginPageStep(HeaderStep headerStep) {
        this.headerStep = headerStep;
    }

    @Given("Navigate to login page")
    public void openLoginPage() {
        loginPage = headerStep.navigateToLoginPage();
    }

    @Then("Login title is visible")
    public void verifyTitle() {
        assertTrue(loginPage.isTitleVisible(), "Title is not displayed on the login page");
    }

    @When("^Enter user credentials username (.*) and password (.*)$")
    public void enterUserCredentials(String username, String password) {
        loginPage.authenticateUser(username, password);
    }

    @Then("Login error message is visible")
    public void invalidCredentials() {
        assertTrue(loginPage.isInvalidCredentialsVisible(), "Invalid credentials error is not visible");
    }
}
