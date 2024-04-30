package com.entab.commonutils.commonlib;

import com.aventstack.extentreports.Status;
import com.entab.commonutils.applications.enums.JavaColors;
import com.entab.commonutils.applications.enums.ReportInfoMessageColorList;
import com.entab.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class CommonLib extends Driver {

    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * This method is used to log the failure message into report
     * @param message The Message
     * @param requireScreenshot The screenshot True/False
     */
    public static void fail(String message, boolean requireScreenshot) {
        log.error(message);
        assertCheck.append(false);
        reporter.showInExtentReport(Status.FAIL, message, requireScreenshot);
    }

    /**
     * This method is used to log the error message into report
     * @param message The Message
     * @param requireScreenshot The screenshot True/False
     */
    public static void error(String message, boolean requireScreenshot) {
        fail(message,requireScreenshot);
    }

    /**
     * This method is used to log the warning message into report
     * @param message The Message
     */
    public void warning(String message) {
        warning(message,false);
    }

    /**
     * This method is used to log the warning message into report
     * @param message The Message
     * @param requireScreenshot The screenshot true/false
     */
    public void warning(String message,boolean requireScreenshot) {
        log.warn(message);
        reporter.showInExtentReport(Status.WARNING, message, requireScreenshot);
    }

    /**
     * This method is used to log the skip message into report
     * @param message The Message
     */
    public void skip(String message) {
        log.warn(message);
        reporter.showInExtentReport(Status.SKIP, message, false);
    }

    /**
     * Logs Info tag - This will consist info for all steps happening within
     * test-case
     */
    public void infoHighlight(String string1WithoutHighlight, String string2WithHighlight,
                              ReportInfoMessageColorList reportInfoMessageColorList) {
        log.info(string1WithoutHighlight.concat(string2WithHighlight));
        infoHighlight(string1WithoutHighlight, string2WithHighlight, reportInfoMessageColorList, false);
    }

    /**
     * Logs Info tag - This will consist info for all steps happening within
     * test-case
     */
    public void infoHighlight(String string1WithoutHighlight, String string2WithHighlight,
                              ReportInfoMessageColorList reportInfoMessageColorList, Boolean requiredScreenshot) {
        reporter.showInExtentReportTextHighlight(string1WithoutHighlight, string2WithHighlight,
                reportInfoMessageColorList, requiredScreenshot);
    }

    /**
     * Logs Info tag - This will consist info for all steps happening within
     * test-case
     */
    public void infoHighlightUnmatchedValue(String itemNamesForComparison, String actualValues,
                                            String expectedValues) {
        reporter.showInExtentReportHighlightUnmatchedValue(itemNamesForComparison, actualValues, expectedValues);
    }

    /**
     * This method used to log the info message into report
     * @param message The message
     */
    public static void info(String message) {
        info(message, false);
    }

    /**
     * This method used to log the message into report
     * @param message The message
     */
    public void logs(String message) {
        log.info(message);
    }

    /**
     * This method used to log the info message into report
     * @param message The message
     * @param requireScreenshot The Screenshot True/False
     */
    public static void info(String message, boolean requireScreenshot) {
        log.info(message);
        reporter.showInExtentReport(Status.INFO, message, requireScreenshot);
    }

    /**
     * This method used to log the info message into report with different colors
     * Based on Color Status Message change
     * Green Color -> represent pass Message
     * Red Color -> represent fail Message
     * Other color -> represent info Message
     * @param message The message
     * @param javaColors The Color
     * @param requireScreenshot The Screenshot True/False
     */
    public void infoColored(String message, JavaColors javaColors, boolean requireScreenshot) {
        log.info(message);
        if (javaColors.equals(JavaColors.GREEN)) {
            reporter.showInExtentReport(Status.PASS, message, requireScreenshot);
        } else if (javaColors.equals(JavaColors.RED)) {
            reporter.showInExtentReport(Status.FAIL, message, requireScreenshot);
        } else {
            reporter.showInExtentReport(Status.INFO, message, requireScreenshot);
        }
    }

    /**
     * This method used to log the pass message into report
     * @param message The message
     */
    public static void pass(String message) {
        log.info(message);
        reporter.showInExtentReport(Status.PASS, message, false);
    }

    /**
     * This method is used to set the status pass or fail based on status
     * @param status The status True/False
     * @param message The Message
     * @param requireScreenshot The Screenshot True/False
     */
    public void setStatusInReport(boolean status, String message, boolean requireScreenshot) {
        if (status) {
            log.info(message);
            reporter.showInExtentReport(Status.PASS, message + " - is visible successfully", requireScreenshot);
        } else {
            log.error(message);
            reporter.showInExtentReport(Status.FAIL, message + " - is NOT VISIBLE", requireScreenshot);
        }
    }

    /**
     * This method is used to set the status pass or fail based on status
     * @param status The status True/False
     * @param passMessage The pass message
     * @param failMessage The fail message
     * @param requireScreenshot The Screenshot True/False
     */
    public void setStatusInReport(boolean status, String passMessage, String failMessage, boolean requireScreenshot) {
        if (status) {
            log.info(passMessage);
            reporter.showInExtentReport(Status.PASS, passMessage, requireScreenshot);
        } else {
            log.error(failMessage);
            reporter.showInExtentReport(Status.FAIL, failMessage, requireScreenshot);
        }
    }

    /**
     * This method is used to log the error message into report
     * @param message The Message
     */
    public static void error(String message) {
        error(message, false);
}

}
