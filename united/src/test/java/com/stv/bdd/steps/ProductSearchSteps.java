package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
import com.stv.factory.utils.Hook;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductSearchSteps {
    private ProductListPage productListPage;
    private HomePage homePage;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        this.homePage = new HomePage();
        this.homePage.acceptCookiesIfPresent();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        this.homePage.getSearchBox(searchTerm);
        this.homePage.enterKeyToSearchBox();
        this.productListPage = new ProductListPage();
        this.productListPage.setElement(searchTerm);
    }

    @When("the user searches for {string} and click search button")
    public void theUserSearchesForAndClickSearchButton(String searchTerm) {
        this.homePage.getSearchBox(searchTerm);
        Assert.assertTrue(this.homePage.searchButtonClick(), "Not implemented search button yet");
        this.productListPage = new ProductListPage();
        this.productListPage.setElement(searchTerm);
    }

    @Then("the product list should contain relevant items")
    public void theProductListShouldContainRelevantItems() {
        Assert.assertTrue(this.productListPage.isRelevantItems(), "Not contains relevant items");
    }

    @After
    public void close(){
        Hook.quitDriver();
    }
}
