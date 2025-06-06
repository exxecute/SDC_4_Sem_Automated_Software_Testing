package com.stv.bdd.steps;

import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        driver = MyDriver.getDriver();
        driver.get(System.getProperty("base.url"));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        loginPage.acceptCookiesIfPresent();
        loginPage.clickAccountIcon();
    }

    @When("I enter {string} into the email field")
    public void iEnterEmail(String email) {
        loginPage.getEmailField().clear();
        loginPage.getEmailField().sendKeys(email);
    }

    @And("I enter {string} into the password field")
    public void iEnterPassword(String password) {
        loginPage.getPasswordField().clear();
        loginPage.getPasswordField().sendKeys(password);
    }

    @And("I click the \"Sign In\" button")
    public void iClickSignInButton() {
        loginPage.getSignInButton().click();
    }

    @Then("I should see an error message about incorrect credentials")
    public void iSeeErrorMessage() {
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed(), "Expected error message is not displayed!");
        MyDriver.quitDriver();
    }
}
