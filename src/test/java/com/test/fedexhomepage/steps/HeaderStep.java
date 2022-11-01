package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.configuration.BrowserDefinition;
import com.test.fedexhomepage.pages.AccountPage;
import com.test.fedexhomepage.pages.Header;
import com.test.fedexhomepage.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderStep {

    private final BrowserDefinition browserDefinition;

    public HeaderStep(BrowserDefinition browserDefinition) {
        this.browserDefinition = browserDefinition;
    }

    @When("Click on login link")
    public LoginPage navigateToLoginPage() {
        Header header = PageFactory.initElements(browserDefinition.getDriver(), Header.class);
        return header.clickOnLogin();
    }

    @When("Click on open account link")
    public AccountPage navigateToOpenAccountPage() {
        Header header = PageFactory.initElements(browserDefinition.getDriver(), Header.class);
        return header.clickOnOpenAccount();
    }

    @Then("My profile page is visible")
    public void verifyUserAuthenticated() {
        Header header = PageFactory.initElements(browserDefinition.getDriver(), Header.class);
        assertTrue(header.userAuthenticated());
    }
}
