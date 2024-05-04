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

    public void clickUserIdTextBox() {
        click(LandingPageElements.userIdField);
    }

    public void enterUserName() {
        enterText(LandingPageElements.userIdField, "7878787878");
    }

    public void clickPasswordTextBox() {
        click(LandingPageElements.passwordField);
    }

    public void enterPassword() {
        enterText(LandingPageElements.passwordField, "Campus@786");
    }

    public void clickLogin() {
        clickWithJS(LandingPageElements.loginButton);


    }

    public void acceptAlert() throws InterruptedException {

        Alert alert = driver.switchTo().alert();
        alert.accept();
        hardWait();

    }

    public String getUserNamePlaceholder() {
        return getAttributeValue(LandingPageElements.userIdField, "placeholder");
    }

    public String getPasswordPlaceholder() {
        return getAttributeValue(LandingPageElements.passwordField, "placeholder");
    }

    public void clickOtpField() {
        click(LandingPageElements.otpField);
    }

    public void enterOtp() throws InterruptedException {
        enterText(LandingPageElements.otpField, "143143");
        hardWait(10);
    }

    public String getOtpPlaceholder() {
        return getAttributeValue(LandingPageElements.otpField, "placeholder");
    }

    public void verifyButton() {
        click(LandingPageElements.verifyButton);
    }

}

