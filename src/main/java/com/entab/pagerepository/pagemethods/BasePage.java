package com.entab.pagerepository.pagemethods;

import com.entab.commonutils.applications.constants.ApplicationConstants;
import com.entab.commonutils.commonlib.CommonLib;
import com.entab.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends Driver {
Actions actions = new Actions(driver);
WebDriverWait wait;


    public BasePage(WebDriver driver) {
        Driver.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(constants.getValue(ApplicationConstants.GLOBAL_WAIT_TIME))));
    }
    public String getText(By elements){
        String text = null;
        if(Boolean.TRUE.equals(isDisplayed(elements))){
            CommonLib.info("Going to get text of :"+elements);
            text = driver.findElement(elements).getText();

        }else {
            CommonLib.error("Web Element:"+elements+ "is NOT displayed");
        }

        return text;
    }
    public void click(By elements){
        if(Boolean.TRUE.equals(isDisplayed(elements))) {
            CommonLib.info("Going to click on : "+elements);
            driver.findElement(elements).click();
        }else{
            CommonLib.error("Web element :"+elements+" is NOT displayed");
        }

    }
    public void enterText(By elements,String text ) {
        if (Boolean.TRUE.equals(isDisplayed(elements))) {
            CommonLib.info("going to enter text in :" + elements);
            driver.findElement(elements).sendKeys(text);
        } else {
            CommonLib.error("Web element :" + elements + "is Not displayed");
        }
    }
    public void hoverWebElement(By elements){
        WebElement element1 = driver.findElement(elements);
        actions.moveToElement(element1).perform();

    }
    public void hardWait() throws InterruptedException {
        hardWait(2);
    }

    public void hardWait(int time) throws InterruptedException {
        Thread.sleep(time);
    }
    public Boolean isDisplayed(By elements){
        CommonLib.info("Going to check if element is displayed or not");
         wait.until(ExpectedConditions.visibilityOfElementLocated(elements));
        boolean displayed = driver.findElement(elements).isDisplayed();
        CommonLib.info("If element visible ? "+displayed);
        return displayed;
    }


}

