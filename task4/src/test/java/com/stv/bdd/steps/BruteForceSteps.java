package com.stv.bdd.steps;

import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.pages.LoginPage;
import com.stv.framework.pages.RegisterPage;
import com.stv.framework.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BruteForceSteps {
    private final static String NEW_EMAIL = "NewEmail@nmail.eu";
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(ConfigReader.get("base.url"));
        this.driver.manage().window().maximize();

        this.registerPage = new RegisterPage(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.loginPage.acceptCookiesIfPresent();
        this.loginPage.clickAccountIcon();
    }


    @When("the user enters new emails several times")
    public void theUserEntersNewEmailsSeveralTimes() {
        for (int i = 0; i < 20; i++) {
            this.loginPage.enterEmail(NEW_EMAIL);
            this.loginPage.clickEmailSubmitButton();

            boolean isCaptchaPresent = this.loginPage.isCaptchaPresented();

            if (isCaptchaPresent) {
                System.out.println("CAPTCHA detected — skipping further input.");
                return;
            }

            this.registerPage.waitPage();
            this.driver.navigate().back();
        }
    }

    @Then("the login should be blocked or an additional security measure should be presented")
    public void theLoginShouldBeBlockedOrAnAdditionalSecurityMeasureShouldBePresented() {
        Assert.assertTrue(this.loginPage.isCaptchaPresented(), "Expected CAPTCHA or security measure was not detected.");
    }
}
