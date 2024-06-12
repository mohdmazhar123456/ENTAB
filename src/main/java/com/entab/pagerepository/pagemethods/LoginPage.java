package com.entab.pagerepository.pagemethods;

import com.entab.pagerepository.pagelocators.LoginPageElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickUserIdTextBox() {
        click(LoginPageElements.userIdField);
    }
    
    
    public void enterUserName() {
        enterText(LoginPageElements.userIdField, "7878787878");
    }

    public void clickPasswordTextBox() {
        click(LoginPageElements.passwordField);
    }

    public void enterPassword() {
        enterText(LoginPageElements.passwordField, "Campus@786");
    }

    public void clickLogin() {
        clickWithJS(LoginPageElements.loginButton);


    }
    
    public void clickDateDropdown() throws InterruptedException{

    	clickWithJS(LoginPageElements.dateDropdown);
    }
    
    public void clickOn2023Session() {
    	
    	clickWithJS(LoginPageElements.session2023);
    }

    public void acceptAlert() throws InterruptedException {

        Alert alert = driver.switchTo().alert();
        alert.accept();
        hardWait();

    }

    public String getUserNamePlaceholder() {
        return getAttributeValue(LoginPageElements.userIdField, "placeholder");
    }

    public String getPasswordPlaceholder() {
        return getAttributeValue(LoginPageElements.passwordField, "placeholder");
    }

    public void clickOtpField() {
        click(LoginPageElements.otpField);
    }

    public void enterOtp() throws InterruptedException {
        enterText(LoginPageElements.otpField, "143143");
        hardWait(10);
    }

    public String getOtpPlaceholder() {
        return getAttributeValue(LoginPageElements.otpField, "placeholder");
    }

    public void verifyButton() {

        click(LoginPageElements.verifyButton);
    }

}
