package com.stv.bdd.runners;

import com.stv.factory.core.drivers.MyDriver;
import com.stv.factory.utils.Hook;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/com/stv/features",
        glue = "com.stv.bdd.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setUp() {
        Hook.setIsTestRunner(true);
    }
    @AfterClass
    public void afterClass() {
        MyDriver.getDriver().quit();
    }
}
