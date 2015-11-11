package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mo_brian on 11/11/15.
 */
public class EmailViewPage {
    public String getEmailSubject(WebDriver driver) {
        WebElement verifySubject = driver.findElement(By.cssSelector("div[class=\"ha\"] h2[id]"));
        return verifySubject.getText();
    }

    public String getEmailBody(WebDriver driver) {
        WebElement verifyBody = driver.findElement(By.cssSelector("div[class=\"a3s\"] div[dir=\"ltr\"]"));
        return verifyBody.getText();
    }
}
