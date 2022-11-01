package com.test.fedexhomepage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer {

    @FindBy(xpath = "//p[contains(., 'Copyright cronn GmbH')]")
    private WebElement copyright;

    public boolean isCopyrightVisible() {
        return copyright.isDisplayed();
    }
}
