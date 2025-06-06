package com.stv.bdd.steps;

import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BruteForceSteps {
    private final static String NEW_EMAIL = "NewEmail@nmail.eu";
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        this.driver = MyDriver.getDriver();
        this.driver.get("https://www.wiggle.com/");
        this.driver.manage().window().maximize();

        this.loginPage = new LoginPage(this.driver);
        this.loginPage.acceptCookiesIfPresent();
        this.loginPage.clickAccountIcon();
    }


    @When("the user enters new emails several times")
    public void theUserEntersNewEmailsSeveralTimes() {
        for (int i = 0; i < 20; i++) {
            this.loginPage.getEmailField().clear();
            this.loginPage.getEmailField().sendKeys(NEW_EMAIL);
            this.loginPage.getEmailSubmitButton().click();

            boolean isCaptchaPresent = this.loginPage.isCaptchaPresented();

            if (isCaptchaPresent) {
                System.out.println("CAPTCHA detected — skipping further input.");
                return;
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("id.wiggle.com/account/register"));

            driver.navigate().back();

            this.loginPage.getEmailField();
        }
    }

    @Then("the login should be blocked or an additional security measure should be presented")
    public void theLoginShouldBeBlockedOrAnAdditionalSecurityMeasureShouldBePresented() {
        boolean isCaptchaPresent = this.loginPage.isCaptchaPresented();
        boolean isSecurityMessagePresent = this.loginPage.isSecurityMessagePresent();
        boolean isSecurityMeasureTriggered = isCaptchaPresent || isSecurityMessagePresent;

        Assert.assertTrue(isSecurityMeasureTriggered, "Expected CAPTCHA or security measure was not detected.");
    }
}
