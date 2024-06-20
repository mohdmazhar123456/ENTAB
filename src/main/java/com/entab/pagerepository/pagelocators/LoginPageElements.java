package com.entab.pagerepository.pagelocators;

import org.openqa.selenium.By;

public class LoginPageElements {
    public static final By userIdField = By.xpath("//input[@id = 'txtUserID']");
    public static final By passwordField = By.xpath("//input[@id='userPassword']");
    public static final By loginButton = By.xpath("//button[@id='btnLogin']/i");
    public static final By otpField = By.xpath("//input[@id='UserOtpText']");
    public static final By verifyButton = By.xpath("//button[@id='btnverifyOtp']");
    public static final By dateDropdown = By.xpath("//*[@id='session_dd']/div[1]/i");
    public static final By session2023 = By.xpath("//*[@id=\"switchSession\"]/li[3]/a");
}
