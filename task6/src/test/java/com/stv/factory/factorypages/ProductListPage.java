package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ProductListPage {
    private final static String DHB_CATEGORY_NAME = "Dhb";
    private WebDriver driver;
    private WebDriverWait wait;

    private String element;

    @FindBy(id = "lblCategoryHeader")
    private WebElement categoryHeader;

    @FindBy(id = "divPagination")
    private WebElement pagination;

    @FindBy(css = "a.swipeNextClick.NextLink")
    private WebElement paginationNext;

    @FindBy(css = "a[title='Home page'][href='/']")
    private WebElement homePageLogo;

    public ProductListPage() {
        this.driver = MyDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public boolean isDhbCategory() {
        return Objects.equals(categoryHeader.getText(), DHB_CATEGORY_NAME);
    }

    public void scrollBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public boolean isPaginationVisible() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.pagination));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void paginationNextClick() {
        this.paginationNext.click();
    }

    public boolean isOnTop() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.categoryHeader));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void goMainPage() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("document.getElementById('HeaderGroup').style.display='block';");

        js.executeScript("arguments[0].click();", this.homePageLogo);
    }

}
