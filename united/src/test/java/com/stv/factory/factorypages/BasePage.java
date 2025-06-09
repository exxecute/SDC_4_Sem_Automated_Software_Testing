package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(int waitSeconds) {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        PageFactory.initElements(driver, this);
    }
}
