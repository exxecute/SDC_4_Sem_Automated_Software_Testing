package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductListPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void getSearchBox(final String element) {
        WebElement searchBox = this.wait.until(ExpectedConditions.elementToBeClickable(By.id("txtSearch")));
        searchBox.sendKeys(element);
        searchBox.sendKeys(Keys.ENTER);
    }
}
