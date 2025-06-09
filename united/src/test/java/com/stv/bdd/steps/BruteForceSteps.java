package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.RegisterPage;
import com.stv.factory.utils.Hook;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class BruteForceSteps {
    private final static String NEW_EMAIL = "NewEmail@nmail.eu";
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        HomePage homePage = new HomePage();
        homePage.acceptCookiesIfPresent();
        homePage.clickAccountIcon();
        this.registerPage = new RegisterPage();
        this.loginPage = new LoginPage();
    }
    
    @When("the user enters new emails several times")
    public void theUserEntersNewEmailsSeveralTimes() {
        for (int i = 0; i < 20; i++) {
            this.loginPage.enterEmail(NEW_EMAIL);
            this.loginPage.clickEmailSubmitButton();

            if (!this.registerPage.isRegisterPage()) {
                return;
            }

            this.registerPage.navigateBack();
        }
    }

    @Then("the login should be blocked or an additional security measure should be presented")
    public void theLoginShouldBeBlockedOrAnAdditionalSecurityMeasureShouldBePresented() {
        Assert.assertTrue(this.loginPage.isCaptchaPresented(), "Expected CAPTCHA or security measure was not detected. ");
    }

    @After
    public void close(){
        Hook.quitDriver();
    }
}
