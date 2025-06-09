package com.stv.factory.factorypages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends BasePage {
    @FindBy(css = "a.logo-wrapper")
    private WebElement logo;

    public CareersPage() {
        super(3);
    }

    public boolean isCareersPage() {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(this.logo));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void browserGoBack() {
        this.driver.navigate().back();
    }
}
