package com.stv.factory.factorypages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "Input_EmailAddress")
    private WebElement emailField;

    @FindBy(id = "emailSubmit")
    private WebElement emailSubmitButton;

    @FindBy(id = "loginMenu")
    private WebElement accountIcon;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = "iframe[src*='recaptcha']")
    private WebElement captcha;

    public LoginPage() {
        super(3);
        this.driver.get(System.getProperty("base.url"));
        this.driver.manage().window().maximize();
    }

    public void enterEmail(final String email) {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailField));
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void clickEmailSubmitButton() {
        this.wait.until(ExpectedConditions.visibilityOf(this.emailSubmitButton));
        this.emailSubmitButton.click();
    }

    public boolean isCaptchaPresented() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.captcha));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickAccountIcon() {
        this.wait.until(ExpectedConditions.visibilityOf(this.accountIcon));
        this.accountIcon.click();
    }

    public void acceptCookiesIfPresent() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.acceptCookies));
            this.acceptCookies.click();
        } catch (TimeoutException ignored) {}
    }
}
