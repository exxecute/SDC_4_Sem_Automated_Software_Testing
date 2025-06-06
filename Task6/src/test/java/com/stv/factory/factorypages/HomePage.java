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

    @FindBy(id = "txtSearch")
    private WebElement searchBox;

    @FindBy(css = "a[href='/dhb']")
    private WebElement availableNowButton;

    @FindBy(id = "topMenu")
    private WebElement topMenu;

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

    public void scrollBottom() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
    }

    public void careersClick() throws InterruptedException {
        WebElement careersLink = driver.findElement(By.linkText("Careers"));
        careersLink.click();
        Thread.sleep(2000);
    }
}