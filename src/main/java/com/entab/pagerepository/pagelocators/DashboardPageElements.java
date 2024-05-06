package com.entab.pagerepository.pagelocators;

import org.openqa.selenium.By;

public class DashboardPageElements {
    public static final By erpField = By.xpath("//p[@class='selectCampus selectMenuTab']");
    public static final By classField = By.xpath("//li[contains(@class,'campusselected')]//*[text()='Class']");
    public static final By addButton = By.xpath ("//span[contains (text(),'Add')]");

}
