package com.test.fedexhomepage.pages;

import com.test.fedexhomepage.configuration.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends LoadableComponent<LoginPage> {

    private final WebDriver driver;

    @FindBy(xpath = "//h1[@id='title']")
    private WebElement title;
    @FindBy(xpath = "//input[@id='userId']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='login-btn']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@id='invalidCredentials']")
    private WebElement invalidCredentials;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.textToBePresentInElement(title, "Enter your user ID and password to log in"))
                .booleanValue();
    }

    @Override
    protected void load() {
        driver.get(Property.getBaseUrl() + "/secure-login/en-gb/#/login-credentials");
    }

    @Override
    protected void isLoaded() throws Error {
        final var url = driver.getCurrentUrl();
        assertTrue(url.endsWith("login-credentials"), "Not on the login page: " + url);
    }

    public void authenticateUser(String fakeUsername, String fakePassword) {
        usernameField.sendKeys(fakeUsername);
        passwordField.sendKeys(fakePassword);
        loginButton.click();
    }

    public boolean isInvalidCredentialsVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.textToBePresentInElement(invalidCredentials, "Login incorrect. Either the user ID or password combination is incorrect, or the account has been locked. Please try again or reset your password.")).booleanValue();
    }
}