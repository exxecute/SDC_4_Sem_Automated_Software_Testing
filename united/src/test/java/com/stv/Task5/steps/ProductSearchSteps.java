package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
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

    @When("the user searches for {string} and click search button")
    public void theUserSearchesForAndClickSearchButton(String searchTerm) {
        this.homePage.getSearchBox(searchTerm);
        this.productListPage = new ProductListPage();
        this.productListPage.setElement(searchTerm);
    }

    @Then("the product list should contain relevant items")
    public void theProductListShouldContainRelevantItems() {
        Assert.assertTrue(this.productListPage.isRelevantItems(), "Not contains relevant items");
    }
}
