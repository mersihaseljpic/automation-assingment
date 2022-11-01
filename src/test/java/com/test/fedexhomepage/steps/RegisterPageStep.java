package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.pages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageStep {

    private final AccountPageStep accountPageStep;

    private RegisterPage registerPage;

    public RegisterPageStep(AccountPageStep accountPageStep) {
        this.accountPageStep = accountPageStep;
    }

    @When("Enter contact information")
    public void enterContactInformation() {
        registerPage = accountPageStep.openAccountButtonClick();
        registerPage.enterContactInformation();
    }

    @Then("Enter fedex user id information")
    public void enterUserInformation() {
        registerPage.enterUserInformation();
    }

    @Then("Shipping account type selection")
    public void selectAccountType() {
        registerPage.selectPersonalAccountType();
    }

    @Then("Credit card details verification")
    public void verifyCreditCardDetailsStep() {
        assertTrue(registerPage.isCreditCardDetailsVisible());
    }
}
