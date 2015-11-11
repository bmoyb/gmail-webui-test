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
public class SignInPage {
    public void fillInUsername(WebDriver driver, String s) {
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("seleniumtest915@gmail.com");
        WebElement clickNext = driver.findElement(By.id("next"));
        clickNext.click();
    }


    public void fillInPassword(WebDriver driver, String selenium123) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement passwordTextbox = driver.findElement(By.name("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("selenium123");
        WebElement checkbox = driver.findElement(By.id("PersistentCookie"));
        checkbox.click();
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebElement signIn = driver.findElement(By.id("signIn"));
        signIn.click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.partialLinkText("Inbox"))));
        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public static boolean isElementExist(WebDriver driver) {
        return driver.findElements(By.cssSelector("input[id=\"Email\"]")).size() > 0;
    }
}
