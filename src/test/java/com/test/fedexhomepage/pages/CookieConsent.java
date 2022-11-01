package com.test.fedexhomepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CookieConsent {

    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'ACCEPT ALL COOKIES')]")
    private WebElement acceptAllCookiesButton;

    public CookieConsent(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAllCookies() {
        acceptAllCookiesButton.click();
    }

    public boolean isAcceptAllCookiesVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton));
        return acceptAllCookiesButton.isDisplayed();
    }
}
