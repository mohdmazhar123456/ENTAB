package com.entab.pagerepository.pagemethods;

import com.entab.pagerepository.pagelocators.DashboardPageElements;
import com.entab.pagerepository.pagelocators.LandingPageElements;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void erpButton(){
        click(DashboardPageElements.erpField);
    }
    public void classButton(){
        click(DashboardPageElements.classField);
    }
    public void addButton(){
        click(DashboardPageElements.addButton);
    }

}

