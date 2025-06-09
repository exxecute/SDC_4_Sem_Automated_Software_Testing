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
import java.util.Objects;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "Input_Password")
    private WebElement password;

    public RegisterPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean isRegisterPage() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.password));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void navigateBack() {
        this.driver.navigate().back();
    }
}
