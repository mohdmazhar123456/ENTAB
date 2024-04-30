package com.entab.driver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.entab.commonutils.applications.constants.ApplicationConstants;
import com.entab.commonutils.applications.constants.ConstantUtils;
import com.entab.commonutils.extentreport.ExtentReport;
import com.entab.pagerepository.pagemethods.PageCollections;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Driver {

    /**
     * This is class variable
     */
    private static String browser;
    private static String env = System.getProperty("env");
    public static WebDriver driver;
    public static String BASE_URL;
    public static ConstantUtils constants = ConstantUtils.getInstance();
    public static PageCollections pages;
    public static StringBuilder assertCheck;
    public static ExtentTest test;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static final StringBuilder TESTCASE_DESCRIPTION_BUILDER = new StringBuilder(); // FOR ADDING TESTCASE DESCRIPTION IN EXTNT REPORTS
    public static final ExtentReport reporter = new ExtentReport();
    public static String MODIFIED_HTML_FILE_PATH = "";
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String SUITE_TYPE = System.getProperty("suiteType");
    public static final LocalDateTime dateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM-HH-mm-ss");
    static String formattedDateTime = dateTime.format(formatter);
    private static final String PATH_DELIMITER = "/";
    public static final String HTML_FILE_PATH = USER_DIR + File.separator + "target" + File.separator + "htmlreport" + File.separator + SUITE_TYPE.toLowerCase() + "-" + env.toLowerCase() + PATH_DELIMITER;


    //public static final String HTML_FILE_PATH = USER_DIR + "/src/main/resources/htmlreport/" + SUITE_TYPE.toLowerCase() + "-" + env.toLowerCase() + PATH_DELIMITER;
    public static String currentClassName;
    public static String currentTestCaseName;
    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());


    @BeforeSuite(alwaysRun = true)
    public void setup(ITestContext tr) {
        reportConfigureBase(tr);
        envSetup();
        browser();
    }

    @BeforeClass
    public void pageSetup() {
        try {
            initializePage();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public static void methodLevelSetup(ITestResult tr) {
        try {
            currentClassName = getClassName(tr);
            ExtentReport.startTest(currentClassName, currentTestCaseName);
            assertCheck = new StringBuilder(); // @ THIS WILL EMPTY ASSERT STRING-BUILDER BEFORE EACH TEST
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void endTest() {
        try {
            ExtentReport.endTest();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @AfterClass(alwaysRun = true)
    public void cleanup() {
        try {
            ExtentReport.endTest();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeSetup() {
        log.info("Going to close all browser instances");
        ExtentReport.endTest();
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }


    /**
     * This method is used to set the env
     */
    private void envSetup() {
        log.info("Going to setup env setup");

        BASE_URL = constants.getValue(ApplicationConstants.BASE_URL);

        if (env.equalsIgnoreCase("sit")) {
            env = "SIT";
        } else if (env.equalsIgnoreCase("uat")) {
            env = "UAT";
        } else if (env.equalsIgnoreCase("prod")) {
            env = "PROD";
        } else {
            env = "SIT";
        }
    }

    private void browser() {
        try {
            log.info("Going to setup browser and is :-" + browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    browserCapabilities();
                    openBaseUrl(BASE_URL);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), false);
        }
    }

    private void browserCapabilities() {
        log.info("Going to setup browser capabilities");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1792,1120");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * This method will initialize the page collection class
     */
    private void initializePage() {
        log.info("Going to initialize Page Class");
        pages = new PageCollections(driver);
    }

    /**
     * This method will open your website
     *
     * @param baseUrl the website url
     */
    public void openBaseUrl(String baseUrl) {
        log.info("Going to open website base url and is :-" + baseUrl);
        driver.get(baseUrl);
    }

    /**
     * This method is used to create or set up the extent report
     *
     * @param tr the tr
     */
    private static void reportConfigureBase(ITestContext tr) {
        try {
            String currentClassName = tr.getAllTestMethods()[0].getInstance().toString();
            String reportTitle = null;
            if (currentClassName.toLowerCase().contains("api")) {
                reportTitle = "APIScenarios";
            } else if (currentClassName.toLowerCase().contains("test")) {
                reportTitle = "Scenarios";
            }
            MODIFIED_HTML_FILE_PATH = HTML_FILE_PATH + SUITE_TYPE + reportTitle + formattedDateTime + ".html";
            browser = constants.getValue(ApplicationConstants.WEB_BROWSER);
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(MODIFIED_HTML_FILE_PATH);
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("ENTAB Automation");
            extent.setSystemInfo("Execution Browser ", browser.toUpperCase());
            extent.setSystemInfo("Language Selected ", "English");
            extent.setSystemInfo("Suite Type", SUITE_TYPE.toUpperCase());
        } catch (Exception ex) {
            log.error("Exception in Method - reportConfigureBase " + ex.getMessage());
        }
    }

    public static String getClassName(ITestResult tr) {
        String className = tr.getMethod().getInstance().getClass().getName();
        int classNameStartingIndex = className.lastIndexOf('.');
        className = className.substring(classNameStartingIndex + 1);
        currentTestCaseName = tr.getMethod().getMethodName();
        return className;
    }

}