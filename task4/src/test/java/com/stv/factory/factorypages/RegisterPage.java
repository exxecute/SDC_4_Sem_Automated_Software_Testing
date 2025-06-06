package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import com.stv.factory.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void waitPage() {
        this.wait.until(ExpectedConditions.urlContains(ConfigReader.get("register.url")));
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }
}
