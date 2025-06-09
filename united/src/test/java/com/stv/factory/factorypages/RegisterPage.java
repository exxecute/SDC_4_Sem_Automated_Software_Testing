package com.stv.factory.factorypages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    @FindBy(id = "Input_Password")
    private WebElement password;

    public RegisterPage() {
        super(3);
    }

    public boolean isRegisterPage() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.password));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean navigateBack() {
        try {
            this.driver.navigate().back();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
