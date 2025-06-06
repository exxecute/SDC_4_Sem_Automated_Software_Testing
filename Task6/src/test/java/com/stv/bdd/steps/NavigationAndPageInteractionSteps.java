package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NavigationAndPageInteractionSteps {
    private HomePage homePage;
    private ProductListPage productListPage;

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        this.homePage = new HomePage();
        this.homePage.acceptCookiesIfPresent();
    }

    @When("the user clicks on Available Now")
    public void theUserClicksOnAvailableNow() {
        this.homePage.scrollToAvailableNowButtonAndClick();
    }

    @Then("a different page should open")
    public void aDifferentPageShouldOpen() {
        Assert.assertTrue(this.homePage.isNotMainPage());
    }

    @And("the page should contain the dhb section")
    public void thePageShouldContainTheDhbSection() {
        this.productListPage = new ProductListPage();
        Assert.assertTrue(this.productListPage.isDhbCategory());
    }

    @And("pagination controls should be visible")
    public void paginationControlsShouldBeVisible() throws InterruptedException {
        this.productListPage.scrollBottom();
        Assert.assertTrue(this.productListPage.isPaginationVisible());
    }

    @When("the user clicks the next page arrow")
    public void theUserClicksTheNextPageArrow() {
        this.productListPage.paginationNextClick();
    }

    @Then("the page should scroll to the top")
    public void thePageShouldScrollToTheTop() {
        Assert.assertTrue(this.productListPage.isOnTop());
    }

    @When("the user returns to the main page")
    public void theUserReturnsToTheMainPage() {
        
    }

    @Then("the main page should be at the bottom")
    public void theMainPageShouldBeAtTheBottom() {
        
    }

    @When("the user clicks on Carriers")
    public void theUserClicksOnCarriers() {
        
    }

    @Then("a new page should open")
    public void aNewPageShouldOpen() {
        
    }

    @When("the user clicks the browser's back button")
    public void theUserClicksTheBrowserSBackButton() {
        
    }

    @Then("the main page should be displayed")
    public void theMainPageShouldBeDisplayed() {
        
    }

    @And("the Carriers section should be in focus")
    public void theCarriersSectionShouldBeInFocus() {
        
    }

    @When("the user clicks the Wiggle logo at the bottom")
    public void theUserClicksTheWiggleLogoAtTheBottom() {
    }

    @Then("the main page should be displayed at header")
    public void theMainPageShouldBeDisplayedAtHeader() {
    }
}
