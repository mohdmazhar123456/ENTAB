package com.entab.driver;

import com.entab.commonutils.applications.ApplicationConstants;
import com.entab.commonutils.applications.ConstantsUtils;
import com.entab.commonutils.commonlib.CommonLib;
import com.entab.pagerepository.pagemethods.PageCollections;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;


public class Driver {
    public static String env = "sit";

    protected static String browser = null;
    protected static String baseUrl;
    public CommonLib commonLib = new CommonLib();
    public PageCollections pages;

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
             pages = new PageCollections(driver);
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

    @AfterClass

    public void cleanUp() {
    }

    @AfterSuite
    public void close() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }

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
                    WebDriverManager.chromedriver().clearDriverCache().setup();
                    browserCapabilities();
                    startBrowser(baseUrl);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1792,1120");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
}