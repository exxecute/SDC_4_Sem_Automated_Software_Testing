package com.stv.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public WebElement getSearchBox() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSearch")));
    }

    public WebElement getFilterElement(String element) {
        return this.driver.findElement(By.xpath("//span[contains(@data-filtername, element)]"));
    }

}
