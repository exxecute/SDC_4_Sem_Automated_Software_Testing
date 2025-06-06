package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ProductSearchSteps {
    private ProductListPage productListPage;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        HomePage homePage = new HomePage();
        homePage.acceptCookiesIfPresent();
        this.productListPage = new ProductListPage();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        this.productListPage.getSearchBox(searchTerm);
    }

    @Then("the product list should contain relevant items")
    public void theProductListShouldContainRelevantItems() {
        Assert.assertTrue(this.productListPage.isRelevantItems(), "Not contains relevant items");
    }
}
