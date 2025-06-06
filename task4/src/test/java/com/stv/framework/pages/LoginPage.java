package com.stv.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "Input_EmailAddress")
    private WebElement emailField;

    @FindBy(id = "emailSubmit")
    private WebElement emailSubmitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
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

    public WebElement getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".dnnFormValidationSummary.field-validation-error")));
    }

    public boolean isCaptchaPresented() {
        return this.driver.findElements(By.cssSelector("iframe[src*='recaptcha']")).size() > 0;
    }

    public boolean isSecurityMessagePresent() {
        return this.driver.findElements(By.xpath("//*[contains(text(), 'security') or contains(text(), 'captcha') or contains(text(), 'verify')]")).size() > 0;
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
