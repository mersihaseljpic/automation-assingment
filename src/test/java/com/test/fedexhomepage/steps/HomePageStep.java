package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.configuration.BrowserDefinition;
import com.test.fedexhomepage.configuration.Property;
import com.test.fedexhomepage.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageStep {

    private final BrowserDefinition browserDefinition;
    private HomePage homePage;

    public HomePageStep(BrowserDefinition browserDefinition) {
        this.browserDefinition = browserDefinition;
    }

    @When("Navigate to home page")
    public void openPage() {
        homePage = PageFactory.initElements(browserDefinition.getDriver(), HomePage.class).get();
    }

    @Then("Title is visible")
    public void verifyTitle() {
        assertTrue(homePage.isTitleVisible(), "Title is not displayed on the home page");
    }

    @Then("Geolocation link is visible")
    public void selectGeolocation() {
        assertTrue(homePage.isGeolocationLinkVisible(), "Geolocation popup is not displayed");
    }

    @Then("Geolocation link clicked")
    public void clickGeolocationLink() {
        homePage.clickGeolocationLink();
    }

    @Then("User enters incorrect track id")
    public void inputIncorrectTrackId() {
        homePage.sendTrackId(Property.getInvalidTrackId());
    }

    @When("Track button is visible")
    public void isTrackButtonVisible() {
        assertTrue(homePage.isTrackVisible(), "Track button is not displayed");
    }

    @Then("User clicks track button")
    public void clickTrackButton() {
        homePage.clickTrackButton();
    }

    @Then("Search result is returned saying Unfortunately, we are unable to retrieve your tracking results at this time")
    public void verifyErrorMessageIsVisible() {
        assertTrue(homePage.isNotificationMessagePresent(), "Notification Messages is not displayed on the home page");
    }

    @When("Rate transit times link is visible")
    public void selectRateTransitLink() {
        assertTrue(homePage.isRateTransitTimesLinkVisible(), "Rate transit times link is not displayed");
    }
    @Then("User clicks on rate transit")
    public void clickRateTransitTimesLink() {
        homePage.clickRateTransitTimesLink();
    }

    @Then("Calculate title is visible")
    public void verifyCalculateTitleVisible() {
        assertTrue(homePage.isCalculateTitleVisible(), "Calculate title is not displayed on the home page");
    }

    @Then("User scroll down to custom tools")
    public void selectCustomLink() {
        assertTrue(homePage.isCustomLinkVisible(), "Custom Link is not displayed");
    }
    @Then("User clicks on custom tools")
    public void clickCustomToolsLink() { homePage.clickCustomToolsLink();
    }

    @Then("User is redirected to custom tools")
    public void customToolsTitlePresent() {
        assertTrue(homePage.customToolsTitlePresent(), "Customs Tools");
    }


    @Then("Ship link is present on homepage")
    public void isShipVisible() {
        assertTrue(homePage.isShipVisible(), "Ship link is visible");
    }
    @Then("User clicks on ship link")
    public void clickShipLink() {homePage.clickShipLink();
    }

    @Then("He is redirected to login screen")
    public void loginTitle() {homePage.loginTitle();
    }

    @Then("Duty and taxes link is visible")
    public void isDutyAndTaxLinkVisible() {
        assertTrue(homePage.isDutyAndTaxLinkVisible(), "Duty and Taxes link is visible");
    }
    @When("User clicks on duty and taxes")
    public void clickDutyAndTaxLink() {homePage.clickDutyAndTaxLink();
    }
    @When("User is redirected to page duty and tax")
    public void isDutiesAndTaxesTitlePresent() {homePage.isDutiesAndTaxesTitlePresent();
    }
    @Then("User clicks on pay tab")
    public void clickPayTab() {homePage.clickPayTab();
    }
    @Then("More information regarding duty and taxes are available")
    public void isPayTitlePresent() {homePage.isPayTitlePresent();
    }
    @Then("Service alert is present")
    public void isServiceAlertsLinkVisible() {homePage.isServiceAlertsLinkVisible();
    }
    @Then("User clicks on service alert")
    public void clickServiceAlertsLink() {homePage.clickServiceAlertsLink();
    }
    @When("User is redirected to service news page")
    public void isServiceNewsTitlePresent() {homePage.isServiceNewsTitlePresent();
    }
}
