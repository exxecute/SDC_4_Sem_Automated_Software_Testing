package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

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
        this.driver = MyDriver.getDriver();
        this.driver.get(System.getProperty("base.url"));
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void scrollToAvailableNowButtonAndClick() {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.availableNowButton);
        this.wait.until(ExpectedConditions.visibilityOf(this.availableNowButton));
        this.availableNowButton.click();
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

    public void acceptCookiesIfPresent() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.acceptCookies));
            this.acceptCookies.click();
        } catch (TimeoutException ignored) {}
    }

    public void scrollBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void careersClick() {
        this.careersLink.click();
    }

    public boolean isCareersVisible() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.careersLink));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public void footerLogoClick() {
        this.footerHomePage.click();
    }

    public void getSearchBox(final String element) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        this.searchBox.sendKeys(element);
        this.searchButton.click();
    }
}