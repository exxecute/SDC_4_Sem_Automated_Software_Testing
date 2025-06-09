package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
    List<WebElement> captchas = new ArrayList<>();

    public LoginPage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(System.getProperty("base.url"));
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
        this.captchas.clear();
        this.captchas.addAll(driver.findElements(By.cssSelector("iframe[src*='recaptcha']")));
        return this.captchas.size() > 1;
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
