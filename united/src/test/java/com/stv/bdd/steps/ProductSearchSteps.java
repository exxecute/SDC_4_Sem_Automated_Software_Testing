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
    private String serchedElement;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        this.homePage = new HomePage();
        this.homePage.acceptCookiesIfPresent();
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        this.serchedElement = searchTerm;
        this.homePage.getSearchBox(searchTerm);
    }

    @And("the user send enter key")
    public void theUserSendEnterKey() {
        this.homePage.enterKeyToSearchBox();
    }

    @And("click search button")
    public void clickSearchButton() {
        Assert.assertTrue(this.homePage.searchButtonClick(), "Not implemented search button yet");
    }

    @Then("the product list should contain relevant items")
    public void theProductListShouldContainRelevantItems() {
        this.productListPage = new ProductListPage();
        this.productListPage.setElement(this.serchedElement);
        Assert.assertTrue(this.productListPage.isRelevantItems(), "Not contains relevant items");
    }

    @After
    public void close(){
        Hook.quitDriver();
    }
}
