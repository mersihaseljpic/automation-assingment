package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.pages.AccountPage;
import com.test.fedexhomepage.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPageStep {

    private final HeaderStep headerStep;

    private AccountPage accountPage;

    public AccountPageStep(HeaderStep headerStep) {
        this.headerStep = headerStep;
    }

    @Given("Navigate to open account page")
    public void openAccountPage() {
        accountPage = headerStep.navigateToOpenAccountPage();
    }

    @Then("Open account button is visible")
    public void verifyTitle() {
        assertTrue(accountPage.isOpenAccountButtonVisible(), "Open account button is not displayed on the account page");
    }

    @When("Open account button clicked")
    public RegisterPage openAccountButtonClick() {
        return accountPage.clickOpenAccountButton();
    }
}
