package com.test.fedexhomepage.pages;

import com.test.fedexhomepage.configuration.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page object that represents home page of https://www.fedex.com/en-gb/home.html
 */
public class HomePage extends LoadableComponent<HomePage> {

    private final WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'now meets next.')]")
    private WebElement title;

    @FindBy(xpath = "//body/dialog[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    private WebElement geolocationLink;

    @FindBy(xpath = "//*[@id=\"cubeOnePar\"]/button")
    private WebElement rateTransitTimesLink;

    @FindBy(xpath = "//h1[contains(text(),'Calculate FedEx® shipping rates.')]")
    private WebElement calculateTitle;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div[1]/div/div[4]/div/div[1]/div/div[1]/div[1]/form/div/input[1]")
    private WebElement trackingIdInput;


    @FindBy(xpath = "//button[@id='btnSingleTrack']")
    private WebElement trackButton;

    @FindBy(xpath = "//div[contains(text(),'Unfortunately, we are unable to retrieve your trac')]")
    private WebElement notificationMessage;

    @FindBy(xpath = "//thead/tr[1]/th[3]/div[1]/div[3]/div[1]/a[1]")
    private WebElement customToolsLink;

    @FindBy(xpath = "//h1[contains(text(),'Customs Tools')]")
    private WebElement customToolsTitle;

    @FindBy(xpath = "//*[@id=\"cubeThreePar\"]/button")
    private WebElement shipLink;

    @FindBy(xpath = "//h1[contains(text(),' Enter your user ID and password to log in')]")
    private WebElement loginTitle;

    @FindBy(xpath = "//thead/tr[1]/th[5]/div[1]/div[3]/div[1]/a[1]")
    private WebElement dutyAndTaxLink;

    @FindBy(xpath = "//h1[contains(text(),'What are duties and taxes?')]")
    private WebElement dutiesAndTaxesTitle;

    @FindBy(xpath = "//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement payTab;

    @FindBy(xpath = "//h2[contains(text(),'How do you pay duties and taxes?')]")
    private WebElement payTitle;

    @FindBy(xpath = "//thead/tr[1]/th[1]/div[1]/div[3]/div[1]/a[1]")
    private WebElement serviceAlertLink;

    @FindBy(xpath = "//h1[contains(text(),'Service News')]")
    private WebElement serviceAlertTitle;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleVisible() {
        return title.isDisplayed();
    }

    public boolean isGeolocationLinkVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(geolocationLink));
        return geolocationLink.isDisplayed();
    }

    public void clickGeolocationLink() {

        geolocationLink.click();
    }

    @Override
    protected void load() {
        driver.get(Property.getBaseUrl() + "/en-gb/home.html");
    }

    @Override
    protected void isLoaded() throws Error {
        final var url = driver.getCurrentUrl();
        assertTrue(url.endsWith("home.html"), "Not on the landing page: " + url);
    }

    public boolean isRateTransitTimesLinkVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(rateTransitTimesLink));
        return rateTransitTimesLink.isDisplayed();
    }
    public void clickRateTransitTimesLink() {
        rateTransitTimesLink.click();
    }

    public boolean isCalculateTitleVisible() {
        return calculateTitle.isDisplayed();
    }

    public void sendTrackId(String TrackingID) {
        trackingIdInput.sendKeys(TrackingID);
    }

    public boolean isTrackVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(trackButton));
        return trackButton.isDisplayed();
    }

    public void clickTrackButton() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(trackButton));
        trackButton.click();
    }

    public boolean isNotificationMessagePresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.textToBePresentInElement(notificationMessage, "Unfortunately, we are unable to retrieve your tracking results at this time. Please try again later.")).booleanValue();
    }
    public boolean isCustomLinkVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(customToolsLink));
        return customToolsLink.isDisplayed();
    }

    public void clickCustomToolsLink() {
        customToolsLink.click();
    }

    public boolean customToolsTitlePresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.textToBePresentInElement(customToolsTitle, "Customs Tools")).booleanValue();

    }

    public boolean isShipVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(shipLink));
        return shipLink.isDisplayed();
    }
    public void clickShipLink() {
        shipLink.click();
    }
    public boolean loginTitle() {
        return loginTitle.isDisplayed();
    }

    public boolean isDutyAndTaxLinkVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(dutyAndTaxLink));
        return dutyAndTaxLink.isDisplayed();
    }
    public void clickDutyAndTaxLink() {
        dutyAndTaxLink.click();
    }

    public boolean isDutiesAndTaxesTitlePresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.textToBePresentInElement(dutiesAndTaxesTitle, "What are duties and taxes?")).booleanValue();
    }
    public void clickPayTab() {
        payTab.click();
    }
    public boolean isPayTitlePresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.textToBePresentInElement(payTitle, "How do you pay duties and taxes?")).booleanValue();
    }

    public boolean isServiceAlertsLinkVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.elementToBeClickable(serviceAlertLink));
        return serviceAlertLink.isDisplayed();
    }
    public void clickServiceAlertsLink() {
        serviceAlertLink.click();
    }
    public boolean isServiceNewsTitlePresent() {
        return new WebDriverWait(driver, Duration.ofSeconds(Property.getTimeout()))
                .until(ExpectedConditions.textToBePresentInElement(serviceAlertTitle, "Service News")).booleanValue();
    }
}
