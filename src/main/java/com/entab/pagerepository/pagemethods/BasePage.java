package com.entab.pagerepository.pagemethods;

import com.entab.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Driver {


    public BasePage(WebDriver driver) {
        Driver.driver = driver;
    }
    public static String getText(By elements){
        return driver.findElement(elements).getText();
    }
}
