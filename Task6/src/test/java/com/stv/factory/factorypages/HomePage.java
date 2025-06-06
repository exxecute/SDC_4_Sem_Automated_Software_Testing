package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(id = "txtSearch")
    private WebElement searchBox;

    @FindBy(css = "a[href='/dhb']")
    private WebElement availiableNowButton;

    public HomePage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(System.getProperty("base.url"));
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void scrollToAvailiableNowButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/dhb']")));
        Point location = button.getLocation();
        long y = location.getY();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, arguments[0]);", y + 600);
        wait.until(ExpectedConditions.visibilityOf(button));
    }

    public void getSearchBox(final String element) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        this.searchBox.sendKeys(element);
        this.searchBox.sendKeys(Keys.ENTER);
    }

    public void acceptCookiesIfPresent() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.acceptCookies));
            this.acceptCookies.click();
        } catch (TimeoutException ignored) {}
    }
}