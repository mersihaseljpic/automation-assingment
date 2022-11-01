package com.test.fedexhomepage.pages;

import com.test.fedexhomepage.configuration.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountPage extends LoadableComponent<AccountPage> {

    private WebDriver driver;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/a[1]")
    private WebElement openAccountButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void load() {
        driver.get(Property.getBaseUrl() + "/en-gb/open-account.html");
    }

    @Override
    protected void isLoaded() throws Error {
        final var url = driver.getCurrentUrl();
        assertTrue(url.endsWith("open-account.html"), "Not on the open account page: " + url);
    }

    public boolean isOpenAccountButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable(openAccountButton));
        return openAccountButton.isDisplayed();
    }

    public RegisterPage clickOpenAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.elementToBeClickable(openAccountButton));
        openAccountButton.click();
        return PageFactory.initElements(driver, RegisterPage.class).get();
    }
}
