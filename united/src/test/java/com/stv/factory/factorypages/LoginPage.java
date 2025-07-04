package com.stv.factory.factorypages;

import com.stv.factory.utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "Input_EmailAddress")
    private WebElement emailField;

    @FindBy(id = "emailSubmit")
    private WebElement emailSubmitButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = "iframe[src*='recaptcha']")
    private WebElement captcha;

    public LoginPage() {
        super(3);
    }

    public boolean enterEmail(final String email) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.emailField));
            this.emailField.clear();
            this.emailField.sendKeys(email);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean clickEmailSubmitButton() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.emailSubmitButton));
            this.emailSubmitButton.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isCaptchaPresented() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.captcha));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
