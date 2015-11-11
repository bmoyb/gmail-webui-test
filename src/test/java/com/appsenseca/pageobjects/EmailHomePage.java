package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mo_brian on 11/10/15.
 */
public class EmailHomePage {

    public SignInPage signOut(WebDriver driver) {
        WebElement profile = driver.findElement(By.cssSelector("span[class=\"gb_Ka gbii\"]"));
        profile.click();

        WebElement signOut = driver.findElement(By.id("gb_71"));
        signOut.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"Email\"]")));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static boolean isElementExist(WebDriver driver) {
        return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
    }
}
