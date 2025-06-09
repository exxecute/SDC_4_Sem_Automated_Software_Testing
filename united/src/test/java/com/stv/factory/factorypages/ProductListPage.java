package com.stv.factory.factorypages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class ProductListPage extends BasePage {
    private final static String DHB_CATEGORY_NAME = "Dhb";
    private String element;

    @FindBy(id = "lblCategoryHeader")
    private WebElement categoryHeader;

    @FindBy(id = "divPagination")
    private WebElement pagination;

    @FindBy(css = "a.swipeNextClick.NextLink")
    private WebElement paginationNext;

    @FindBy(css = "a[title='Home page'][href='/']")
    private WebElement homePageLogo;

    @FindBy(css = "#navlist > li")
    private List<WebElement> productItems;

    public ProductListPage() {
        super(3);
    }

    public boolean setElement(final String element) {
        this.element = element;
        return true;
    }

    public boolean isDhbCategory() {
        return Objects.equals(categoryHeader.getText(), DHB_CATEGORY_NAME);
    }

    public boolean scrollBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return true;
    }

    public boolean isPaginationVisible() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.pagination));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean paginationNextClick() {
        try {
            this.paginationNext.click();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isOnTop() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.categoryHeader));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean goMainPage() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("document.getElementById('HeaderGroup').style.display='block';");

        js.executeScript("arguments[0].click();", this.homePageLogo);
        return true;
    }

    public boolean isRelevantItems() {
        return productItems.stream()
                .anyMatch(p -> {
                    String liName = p.getAttribute("li-name").toLowerCase();
                    for (String word : this.element.toLowerCase().split("\\s+")) {
                        if (liName.contains(word)) {
                            return true;
                        }
                    }
                    return false;
                });
    }
}
