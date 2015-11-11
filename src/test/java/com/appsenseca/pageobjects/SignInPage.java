package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mo_brian on 11/10/15.
 */
public class SignInPage {
    public void fillInUsername(WebDriver driver, String text) {
        WebUtil.sendKeys(driver, text, By.id("Email") );
        WebUtil.click(driver,By.id("next") );
    }


    public void fillInPassword(WebDriver driver, String text) {
        WebUtil.waitForElementVisible(driver,By.id("Passwd") );
        WebUtil.sendKeys(driver, text, By.name("Passwd"));
        WebUtil.click(driver, By.id("PersistentCookie"));
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebUtil.click(driver, By.id("signIn"));
        WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));
        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public static boolean isElementExist(WebDriver driver) {
        return WebUtil.doesElementExist(driver, By.cssSelector("input[id=\"Email\"]"));
    }
}
