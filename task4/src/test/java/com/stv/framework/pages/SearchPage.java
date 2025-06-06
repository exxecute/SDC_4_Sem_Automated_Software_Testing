package com.stv.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement getSearchInput() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSearch")));
    }

    public WebElement getSearchHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
    }

    public WebElement getFirstProduct() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("span.productdescriptionname")));
        return products.get(0);
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookies.click();
        } catch (TimeoutException ignored) {}
    }
}
