package com.stv.bdd.steps;

import com.stv.factory.factorypages.CareersPage;
import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
import com.stv.factory.utils.Hook;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NavigationAndPageInteractionSteps {
    private HomePage homePage;
    private ProductListPage productListPage;
    private CareersPage careersPage;

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
        Assert.assertFalse(this.homePage.isMainPage(), "A different page should open");
    }

    @And("the page should contain the dhb section")
    public void thePageShouldContainTheDhbSection() {
        this.productListPage = new ProductListPage();
        Assert.assertTrue(this.productListPage.isDhbCategory(), "It should be Dhb category");
    }

    @And("pagination controls should be visible")
    public void paginationControlsShouldBeVisible()  {
        this.productListPage.scrollBottom();
        Assert.assertTrue(this.productListPage.isPaginationVisible(), "Pagination should be visible");
    }

    @When("the user clicks the next page arrow")
    public void theUserClicksTheNextPageArrow() {
        this.productListPage.paginationNextClick();
    }

    @Then("the page should scroll to the top")
    public void thePageShouldScrollToTheTop() {
        Assert.assertTrue(this.productListPage.isOnTop(), "You should be on the top of the page");
    }

    @When("the user returns to the main page")
    public void theUserReturnsToTheMainPage() {
        this.productListPage.goMainPage();
    }

    @When("the user scroll to the bottom")
    public void theUserScrollToTheBottom() {
        this.homePage.scrollBottom();
    }

    @Then("pagination controls shouldn't be visible")
    public void paginationControlsShouldnTBeVisible() {
        Assert.assertFalse(this.productListPage.isPaginationVisible(), "Pagination shouldn't be visible");
    }

    @When("the user clicks on Carriers")
    public void theUserClicksOnCarriers() {
        this.homePage.careersClick();
    }

    @Then("a new page should open")
    public void aNewPageShouldOpen() {
        Assert.assertFalse(this.homePage.isMainPage(), "It shouldn't be main page");
        this.careersPage = new CareersPage();
        Assert.assertTrue(careersPage.isCareersPage(), "It isn't careers page");
    }

    @When("the user clicks the browser's back button")
    public void theUserClicksTheBrowserSBackButton() {
        this.careersPage.browserGoBack();
    }

    @Then("the main page should be displayed")
    public void theMainPageShouldBeDisplayed() {
        Assert.assertTrue(this.homePage.isMainPage(), "It should be main page");
    }

    @And("the Carriers section should be visible")
    public void theCarriersSectionShouldBeVisible() {
        Assert.assertTrue(this.homePage.isCareersVisible(), "Careers should be visible");
    }

    @When("the user clicks the Wiggle logo at the bottom")
    public void theUserClicksTheWiggleLogoAtTheBottom() {
        this.homePage.footerLogoClick();
    }

    @Then("the main page should be displayed at header")
    public void theMainPageShouldBeDisplayedAtHeader() {
        Assert.assertTrue(this.homePage.isHeaderGroupVisible(), "It's not at top of the page");
    }

    @After
    public void close(){
        Hook.quitDriver();
    }
}
