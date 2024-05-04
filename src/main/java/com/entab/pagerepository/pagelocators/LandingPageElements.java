package com.entab.pagerepository.pagelocators;

import org.openqa.selenium.By;

public class LandingPageElements {
    public static final By landingPageTitle = By.xpath("//label[@id='SchoolName']");
    public static final By enterToLoginPage = By.xpath("//label[@class='loginbtn']");
    public static final By userIdField = By.xpath("//input[@id = 'txtUserID']");
    public static final By passwordField = By.xpath("//input[@id='userPassword']");
    public static final By loginButton = By.xpath("//button[@id='btnLogin']/i");
    public static final By otpField = By.xpath("//input[@id='UserOtpText']");
    public static final By verifyButton = By.xpath("//button[@id='btnverifyOtp']");




}
