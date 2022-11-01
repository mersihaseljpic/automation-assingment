package com.test.fedexhomepage.configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserDefinition {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";
    private WebDriver driver;

    @Before
    public void setupBrowser() {
        final String browserType = Property.getBrowser();
        if (CHROME.equalsIgnoreCase(browserType)) {
            setupChrome();
        } else if (FIREFOX.equalsIgnoreCase(browserType)) {
            setupFirefox();
        }
        setupWindowSize();
        setupTimeouts();
    }

    private void setupChrome() {
        WebDriverManager.chromedriver().setup();
        final var options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
    }

    private void setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        final var options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }

    private void setupWindowSize() {
        driver.manage().window().maximize();
    }

    private void setupTimeouts() {
        final int timeout = Property.getTimeout();
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(timeout))
                .implicitlyWait(Duration.ofSeconds(timeout));
    }

    /**
     * We cleanup after each example/scenario, so that each test has their own pristine browser.
     */
    @After
    public void teardown(final Scenario scenario) {
        if (scenario.isFailed()) {
            final var screenshot = (TakesScreenshot) driver;
            final var data = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
