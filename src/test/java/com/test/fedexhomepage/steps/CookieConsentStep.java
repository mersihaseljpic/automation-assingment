package com.test.fedexhomepage.steps;

import com.test.fedexhomepage.configuration.BrowserDefinition;
import com.test.fedexhomepage.pages.CookieConsent;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookieConsentStep {

    private final BrowserDefinition browserDefinition;

    public CookieConsentStep(BrowserDefinition browserDefinition) {
        this.browserDefinition = browserDefinition;
    }

    @Then("Accept all cookies")
    public void acceptAllCookies() {
        final var cookies = PageFactory.initElements(browserDefinition.getDriver(), CookieConsent.class);
        assertTrue(cookies.isAcceptAllCookiesVisible());
        cookies.acceptAllCookies();
    }

}
