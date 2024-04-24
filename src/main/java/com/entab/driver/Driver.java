package com.entab.driver;

import com.entab.commonutils.Applications.ApplicationConstants;
import com.entab.commonutils.Applications.ConstantsUtils;
import com.entab.pagerepository.pagemethods.PageCollections;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;


public class Driver {
    public static String env = System.getProperty("env");

    protected static String browser = null;
    protected static String baseUrl;

    public static WebDriver driver;
    private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    public static ConstantsUtils constants = ConstantsUtils.getInstance();

    @BeforeSuite
    public void setupEnv() {
        envSetup();
        setBrowser();
    }

    @BeforeClass
    private void pageSetup() {
        try {
            PageCollections pages = new PageCollections(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @BeforeMethod
    public static void methodLevelSetup() {

    }

    @AfterMethod
    public static void endTest() {
    }

    @BeforeClass

    public void cleanUp() {
    }

    @BeforeSuite
    public void close() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }

    }

    public void setEnv() {
    }

    private void envSetup() {
        log.info("going to setup Env");
        browser = constants.getValue(ApplicationConstants.WEB_BROWSER);
        baseUrl = constants.getValue(ApplicationConstants.BASE_URL);
        if (env.equalsIgnoreCase("sit")) {
            env = "SIT";
        } else if (env.equalsIgnoreCase("uat")) {
            env = "UAT";
        } else if (env.equalsIgnoreCase("prod")) {
            env = "UAT";
        }
    }

    private void setBrowser() {
        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    browserCapabilities();
                    startBrowser(baseUrl);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "safari":
                    WebDriverManager.chromedriver().setup();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void startBrowser(String baseUrl) {
        driver.get(baseUrl);
    }

    public void browserCapabilities() {

    }
}