package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mo_brian on 11/11/15.
 */
public class EmailViewPage {
    public String getEmailSubject(WebDriver driver) {
        WebUtil.waitForElementVisible(driver,By.cssSelector("div[class=\"ha\"] h2[id]"));
        return WebUtil.getElementText(driver, By.cssSelector("div[class=\"ha\"] h2[id]"));

    }

    public String getEmailBody(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class=\"a3s\"] div[dir=\"ltr\"]"));
        return WebUtil.getElementText(driver, By.cssSelector("div[class=\"a3s\"] div[dir=\"ltr\"]"));
    }
}
