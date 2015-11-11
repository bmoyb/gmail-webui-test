package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public void composeEmail(WebDriver driver) {
        WebElement compose = driver.findElement(By.cssSelector("div[role=\"button\"][class=\"T-I J-J5-Ji T-I-KE L3\"]"));
        compose.click();
    }


    public void fillRecipient(WebDriver driver, String s) {
        WebElement recipient = driver.findElement(By.cssSelector("textarea[name=\"to\"]"));
        recipient.clear();
        recipient.sendKeys(s);
    }

    public void fillSubject(WebDriver driver, String s) {
        WebElement subject = driver.findElement(By.cssSelector("input[name=\"subjectbox\"]"));
        subject.clear();
        subject.sendKeys(s);
    }

    public void fillBody(WebDriver driver, String s) {
        WebElement body = driver.findElement(By.cssSelector("div[aria-label=\"Message Body\"]"));
        body.clear();
        body.sendKeys(s);
    }

    public void hitSend(WebDriver driver) {
        WebElement send = driver.findElement(By.cssSelector("div[role=\"button\"][aria-label*=\"Send\"]"));
        send.click();
    }

    public void refreshInbox(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        WebElement inbox = driver.findElement(By.partialLinkText("Inbox"));
        inbox.click();
    }

    public EmailViewPage openEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"y6\"] span[id] b")));
        WebElement clickEmail = driver.findElement(By.cssSelector("div[class=\"y6\"] span[id] b"));
        clickEmail.click();

        return PageFactory.initElements(driver, EmailViewPage.class);
    }

    public void deleteNewestEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class=\"F cf zt\"]")));
        WebElement table = driver.findElement(By.cssSelector("div [class=\"F cf zt\"]")); //get table class
        List<WebElement> td=table.findElements(By.tagName("tbody")); //make List webelement to store all "tbody" tags
        WebElement emailCheckbox = td.get(0).findElement(By.cssSelector("div[class=\"T-Jo-auh\"]")); //grab first td.get(0) tag
        emailCheckbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]")));
        WebElement deleteEmail = driver.findElement(By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]"));
        deleteEmail.click();
    }
}
