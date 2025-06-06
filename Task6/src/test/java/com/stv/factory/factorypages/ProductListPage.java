package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class ProductListPage {
    private final static String DHB_CATEGORY_NAME = "Dhb";
    private WebDriver driver;
    private WebDriverWait wait;
    private String element;

    @FindBy(css = "#navlist > li")
    private List<WebElement> productItems;

    @FindBy(id = "lblCategoryHeader")
    private WebElement categoryHeader;

    @FindBy(id = "divPagination")
    private WebElement pagination;

    public ProductListPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean isDhbCategory() {
        return Objects.equals(categoryHeader.getText(), DHB_CATEGORY_NAME);
    }

    public void scrollBottom() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
    }

    public boolean isPaginationVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(this.pagination));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
