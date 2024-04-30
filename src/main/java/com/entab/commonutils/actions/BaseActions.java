package com.entab.commonutils.actions;

import com.entab.commonutils.commonlib.CommonLib;
import org.testng.Assert;

public class BaseActions {

    public static Boolean assertFlag = null;

    /**
     * This method is used to assert two boolean values
     *
     * @param actual   the actual value
     * @param expected the expected value
     * @param pass     the pass description
     * @param fail     the fail description
     * @return boolean
     */
    public static Boolean assertEqualBoolean(boolean actual, boolean expected, String pass, String fail) {
        assertFlag = false;
        try {
            Assert.assertNotNull(actual, pass);
            CommonLib.pass(pass);
            assertFlag = true;
        } catch (Exception e) {
            CommonLib.error(e.getMessage(), false);
        }
        return assertFlag;
    }

    /**
     * Verify.
     *
     * @param actual   the actual
     * @param expected the expected
     */
    public static Boolean assertEqualStringType(String actual, String expected, String passMessage, String failMessage) {
        return assertEqualStringType(actual, expected, passMessage, failMessage, true);
    }

    public static Boolean assertEqualStringType(String actual, String expected, String passMessage, String failMessage, boolean requiredScreenshot) {
        assertFlag = false;
        boolean shouldCaptureScreenshot = true;
        try {
            if (!requiredScreenshot) {
                shouldCaptureScreenshot = false;
            }
            Assert.assertEquals(actual, expected);
            CommonLib.pass(passMessage);
            assertFlag = true;
        } catch (Exception | AssertionError ex) {
            CommonLib.fail(ex.getMessage() + failMessage, shouldCaptureScreenshot);
        }
        return assertFlag;
    }

    /**
     * This method is used to assert two Double values
     *
     * @param actual   the actual value
     * @param expected the expected value
     * @param pass     the pass description
     * @param fail     the fail description
     * @return boolean
     */
    public static Boolean assertEqualDouble(Double actual, Double expected, String pass, String fail) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected, pass);
            assertFlag = true;
        } catch (Exception e) {
            CommonLib.error(fail + " " + e.getMessage(), false);
        }
        return assertFlag;
    }

    /**
     * This method is used to check all assertion are passed or not
     *
     * @param assertCheck all assertions status
     */
    public static boolean checkAllAssertCheck(StringBuilder assertCheck) {
        if (assertCheck.isEmpty() || assertCheck.toString().contains("false")) {
            Assert.fail("Some Assertions got Failed");
            CommonLib.fail("Some Assertions got Failed", false);
            return true;
        } else {
            CommonLib.pass("All assertion verified and are passed");
        }
        return false;
    }


}
