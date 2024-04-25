package com.entab.pagerepository.pagemethods;

import com.entab.pagerepository.pagelocators.LandingPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{
    LandingPageElements pageElements;
    public LandingPage(WebDriver driver){
        super(driver);
      pageElements = PageFactory.initElements(driver,LandingPageElements.class);

    }
    public String getLandingPageTitleText(){
        return getText(pageElements.landingPageTitle);
    }

}
