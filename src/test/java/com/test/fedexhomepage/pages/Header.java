package com.test.fedexhomepage.pages;

import com.test.fedexhomepage.configuration.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;

    @FindBy(xpath = "//a[@id='fxg-dropdown-signIn']")
    private WebElement loginElement;

    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
    private WebElement loginLink;
    @FindBy(xpath = "//header/nav[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]")
    private WebElement openAccountLink;
    @FindBy(xpath = "//a[contains(text(),'SIGN OUT')]")
    private WebElement signOut;
    public Header(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage clickOnLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(loginElement))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(loginLink))
                .click();
        return PageFactory.initElements(driver, LoginPage.class).get();
    }

    public AccountPage clickOnOpenAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(loginElement))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(openAccountLink))
                .click();
        return PageFactory.initElements(driver, AccountPage.class).get();
    }


    public boolean userAuthenticated() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(signOut));
        return signOut.isDisplayed();
    }
}
