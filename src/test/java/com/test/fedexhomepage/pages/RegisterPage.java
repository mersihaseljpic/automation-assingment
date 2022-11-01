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

public class RegisterPage extends LoadableComponent<RegisterPage> {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressInput;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneInput;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//button[contains(text(),'Enter login details')]")
    private WebElement submitContactButton;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//label[@id='PP_AND_TAC-label']")
    private WebElement termsCheckbox;
    @FindBy(xpath = "//button[contains(text(),'Create my User ID')]")
    private WebElement createUserButton;
    @FindBy(xpath = "//button[contains(text(),'Create account')]")
    private WebElement createAccountButton;
    @FindBy(xpath = "//h2[contains(text(),'Add your credit card details to open a FedEx® ship')]")
    private WebElement creditCardDetails;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.get(Property.getBaseUrl() + "/register/#/contact");
    }

    @Override
    protected void isLoaded() throws Error {
        final var url = driver.getCurrentUrl();
        assertTrue(url.endsWith("contact"), "Not on the register page: " + url);
    }

    public void enterContactInformation() {
        firstNameInput.sendKeys("Test");
        lastNameInput.sendKeys("Test");
        addressInput.sendKeys("LIVERPOOL STREET STATION");
        postalCodeInput.sendKeys("EC2M 7QA");
        cityInput.sendKeys("LONDON");
        phoneInput.sendKeys("123456895");
        emailInput.sendKeys("test@test.com");
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout() * 5))
                .until(ExpectedConditions.elementToBeClickable(submitContactButton));
        submitContactButton.click();
    }

    public void enterUserInformation() {
        passwordInput.sendKeys("Password123");
        confirmPasswordInput.sendKeys("Password123");
        termsCheckbox.click();
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout() * 2))
                .until(ExpectedConditions.elementToBeClickable(createUserButton));
        createUserButton.click();
    }

    public void selectPersonalAccountType() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout() * 2))
                .until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    public boolean isCreditCardDetailsVisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout() * 2))
                .until(ExpectedConditions.textToBePresentInElement(creditCardDetails, "credit card details")).booleanValue();
    }
}
