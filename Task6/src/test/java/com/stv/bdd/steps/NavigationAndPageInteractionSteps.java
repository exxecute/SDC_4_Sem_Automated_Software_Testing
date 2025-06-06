package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationAndPageInteractionSteps {
    private HomePage homePage;

    @Given("the user is on the main page")
    public void theUserIsOnTheMainPage() {
        this.homePage = new HomePage();
        this.homePage.acceptCookiesIfPresent();
    }

    @When("the user clicks on Available Now")
    public void theUserClicksOnAvailableNow() throws InterruptedException {
        this.homePage.scrollToAvailableNowButton();
    }

    @Then("a different page should open")
    public void aDifferentPageShouldOpen() {
        
    }

    @And("the page should contain the dhb section")
    public void thePageShouldContainTheDhbSection() {
    }

    @And("pagination controls should be visible")
    public void paginationControlsShouldBeVisible() {
        
    }

    @When("the user clicks the next page arrow")
    public void theUserClicksTheNextPageArrow() {
        
    }

    @Then("the page should scroll to the top")
    public void thePageShouldScrollToTheTop() {
        
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
