package com.stv.bdd.runners;

import com.stv.factory.core.drivers.MyDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@CucumberOptions(
        features = "src/test/java/com/stv/features",
        glue = "com.stv.bdd.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterClass
    public void afterClass() {
        MyDriver.getDriver().quit();
    }
}
