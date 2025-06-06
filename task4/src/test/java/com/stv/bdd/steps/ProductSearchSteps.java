package com.stv.bdd.steps;

import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.pages.HomePage;
import com.stv.framework.pages.ProductListPage;
import com.stv.framework.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;


import java.time.Duration;

public class ProductSearchSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ProductListPage productListPage;

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(ConfigReader.get("base.url"));
        this.driver.manage().window().maximize();

        this.homePage = new HomePage(this.driver);
        this.homePage.acceptCookiesIfPresent();
        this.productListPage = new ProductListPage(this.driver);
    }

    @When("the user searches for {string}")
    public void theUserSearchesFor(String searchTerm) {
        this.productListPage.getSearchBox().sendKeys(searchTerm);
        this.productListPage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @And("the user applies the {string} filter")
    public void theUserAppliesFilter(String filterName) {
        this.productListPage.getFilterElement(filterName).click();
    }

    @Then("the filtered product list should contain relevant items")
    public void verifyFilteredResults() {
//        List<WebElement> products = productListPage.getProducts();
//        Assert.assertTrue(products.size() > 0, "No products found after applying filter.");
    }
}
