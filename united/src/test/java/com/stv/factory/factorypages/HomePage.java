package com.stv.factory.factorypages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;
import java.util.Objects;

public class HomePage extends BasePage {
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = "a[href='/dhb']")
    private WebElement availableNowButton;

    @FindBy(id = "topMenu")
    private WebElement topMenu;

    @FindBy(linkText = "Careers")
    private WebElement careersLink;

    @FindBy(css = "div.footerLogo")
    private WebElement footerHomePage;

    @FindBy(id = "HeaderGroup")
    private WebElement headerGroup;

    @FindBy(id = "txtSearch")
    private WebElement searchBox;

    @FindBy(id = "searchButton")
    private WebElement searchButton;

    public HomePage() {
        super(5);
        this.driver.get(System.getProperty("base.url"));
        this.driver.manage().window().maximize();
    }

    public boolean scrollToAvailableNowButtonAndClick() {
        try {
            Actions actions = new Actions(this.driver);
            actions.moveToElement(this.availableNowButton);
            this.wait.until(ExpectedConditions.visibilityOf(this.availableNowButton));
            this.availableNowButton.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isMainPage() {
        return Objects.equals(driver.getCurrentUrl(), System.getProperty("base.url"));
    }

    public boolean isHeaderGroupVisible() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.headerGroup));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public boolean acceptCookiesIfPresent() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.acceptCookies));
            this.acceptCookies.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean scrollBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return true;
    }

    public boolean careersClick() {
        try {
            this.careersLink.click();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isCareersVisible() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.careersLink));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public boolean footerLogoClick() {
        try {
            this.footerHomePage.click();
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean getSearchBox(final String element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
            this.searchBox.sendKeys(element);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean enterKeyToSearchBox() {
        try {
            this.searchBox.sendKeys(Keys.ENTER);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean searchButtonClick() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.searchButton));
            this.searchButton.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}