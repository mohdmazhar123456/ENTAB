package com.entab.commonutils.commonlib;

import com.entab.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;


public class CommonLib extends Driver {
    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * This method is used to print the info log
     *
     * @param msg the msg(string)
     */
    public static void info(String msg) {
        log.info(msg);
    }

    /**
     * This method is used to enter the error log
     *
     * @param msg the msg(string)
     */
    public static void error(String msg) {
        log.error(msg);

    }
}
