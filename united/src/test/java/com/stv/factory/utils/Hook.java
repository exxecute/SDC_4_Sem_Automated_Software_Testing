package com.stv.factory.utils;

import com.stv.factory.core.drivers.MyDriver;

public class Hook {
    private static boolean isTestRunner = false;

    public static void setIsTestRunner(boolean testRunner) {
        isTestRunner = testRunner;
    }

    public static void quitDriver() {
        if(!isTestRunner) {
            MyDriver.getDriver().quit();
        }
    }
}
