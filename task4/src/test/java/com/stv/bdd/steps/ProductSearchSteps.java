package com.stv.bdd.steps;

import com.stv.factory.factorypages.HomePage;
import com.stv.factory.factorypages.ProductListPage;
import io.cucumber.java.en.*;

public class ProductSearchSteps {
    private HomePage homePage;
    private ProductListPage productListPage;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        this.homePage = new HomePage();
        this.homePage.acceptCookiesIfPresent();
        this.productListPage = new ProductListPage();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        this.productListPage.getSearchBox(searchTerm);
    }

    @Then("the filtered product list should contain relevant items")
    public void verifyFilteredResults() {
//        List<WebElement> products = productListPage.getProducts();
//        Assert.assertTrue(products.size() > 0, "No products found after applying filter.");
    }
}
