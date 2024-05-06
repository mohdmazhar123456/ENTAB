package com.entab.pagerepository.pagemethods;

import com.entab.pagerepository.pagelocators.LandingPageElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    LandingPageElements pageElements;

    public LandingPage(WebDriver driver) {
        super(driver);
        pageElements = PageFactory.initElements(driver, LandingPageElements.class);

    }

    public String getLandingPageTitleText() {
        return getText(LandingPageElements.landingPageTitle);
    }

    public void clickLoginBtn() {
        click(LandingPageElements.enterToLoginPage);
    }

    public String getUrl() throws InterruptedException {
        hardWait();
        return driver.getCurrentUrl();
    }


}

