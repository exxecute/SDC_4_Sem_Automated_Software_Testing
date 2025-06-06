package com.stv.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public WebElement getEmailField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Input_EmailAddress")));
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login_Password")));
    }

    public WebElement getEmailSubmitButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailSubmit")));
    }

    public WebElement getSignInButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("LoginButton")));
    }

    public WebElement getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".dnnFormValidationSummary.field-validation-error")));
    }

    public void clickAccountIcon() {
        WebElement accountIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginMenu")));
        accountIcon.click();
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookies.click();
        } catch (TimeoutException ignored) {}
    }
}
