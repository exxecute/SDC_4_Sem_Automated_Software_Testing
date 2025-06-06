package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "a.logo-wrapper")
    private WebElement logo;

    public CareersPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean isCareersPage() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.logo));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void browserGoBack() {
        this.driver.navigate().back();
    }
}
