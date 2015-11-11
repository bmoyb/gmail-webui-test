package com.appsenseca.util;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mo_brian on 11/10/15.
 */
public class WebUtil {
    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean doesElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static void sendKeys(WebDriver driver,String text, By by) {
        WebElement recipient = driver.findElement(by);
        recipient.clear();
        recipient.sendKeys(text);
    }

    public static String getElementText(WebDriver driver, By by) {
        WebElement verifySubject = driver.findElement(by);
        return verifySubject.getText();
    }
}
