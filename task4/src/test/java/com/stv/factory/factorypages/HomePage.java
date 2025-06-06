package com.stv.factory.factorypages;

import com.stv.factory.core.drivers.MyDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public HomePage() {
        this.driver = MyDriver.getDriver();
        this.driver.get(System.getProperty("base.url"));
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
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