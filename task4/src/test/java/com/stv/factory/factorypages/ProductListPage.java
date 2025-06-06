package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String element;

    @FindBy(css = "#navlist > li")
    private List<WebElement> productItems;

    public ProductListPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public void setElement(final String element) {
        this.element = element;
    }

    public boolean isRelevantItems() {
        return productItems.stream()
                .anyMatch(p -> this.element.equals(p.getAttribute("li-name")));
    }
}
