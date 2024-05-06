package com.entab.pagerepository.pagemethods;

import com.entab.pagerepository.pagelocators.LandingPageElements;
import org.openqa.selenium.WebDriver;

public class PageCollections {
    private final WebDriver driver;

    public PageCollections(WebDriver driver) {
        this.driver = driver;
    }
    public LandingPage getLandingPage(){
        return new LandingPage(driver);
    }
    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }
    public DashboardPage getDashboardPage(){
        return new DashboardPage(driver);
    }
}
