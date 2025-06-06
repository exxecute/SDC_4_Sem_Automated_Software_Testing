package com.stv.framework.pages;

import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.utils.ConfigReader;
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

    @FindBy(id = "loginMenu")
    private WebElement accountIcon;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = "iframe[src*='recaptcha']")
    private WebElement captchaIframe;

    public LoginPage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(ConfigReader.get("base.url"));
        this.driver.manage().window().maximize();
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

    public boolean isCaptchaPresented() {
        return this.wait.until(ExpectedConditions.visibilityOf(this.captchaIframe)) != null;
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
