package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
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
        WebUtil.click(driver, By.cssSelector("span[class=\"gb_Ka gbii\"]"));
        WebUtil.click(driver,By.id("gb_71") );
        WebUtil.waitForElementVisible(driver, By.cssSelector("input[id=\"Email\"]"));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static boolean isElementExist(WebDriver driver) {
        return WebUtil.doesElementExist(driver, By.partialLinkText("Inbox"));
    }

    public void composeEmail(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[role=\"button\"][class=\"T-I J-J5-Ji T-I-KE L3\"]"));
    }


    public void fillRecipient(WebDriver driver, String text) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("textarea[name=\"to\"]"));
        WebUtil.sendKeys(driver, text, By.cssSelector("textarea[name=\"to\"]"));
    }

    public void fillSubject(WebDriver driver, String text) {
        WebUtil.sendKeys(driver, text, By.cssSelector("input[name=\"subjectbox\"]"));
    }

    public void fillBody(WebDriver driver, String text) {
        WebUtil.sendKeys(driver, text, By.cssSelector("div[aria-label=\"Message Body\"]"));
    }

    public void hitSend(WebDriver driver) {
        WebUtil.click(driver,By.cssSelector("div[role=\"button\"][aria-label*=\"Send\"]") );
    }

    public void refreshInbox(WebDriver driver) {
        WebUtil.waitForElementVisible(driver,By.partialLinkText("Inbox") );
        WebUtil.click(driver, By.partialLinkText("Inbox"));
    }

    public EmailViewPage openEmail(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class=\"y6\"] span[id] b"));
        WebUtil.click(driver, By.cssSelector("div[class=\"y6\"] span[id] b"));

        return PageFactory.initElements(driver, EmailViewPage.class);
    }

    public void deleteNewestEmail(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div [class=\"F cf zt\"]"));

        WebElement table = driver.findElement(By.cssSelector("div [class=\"F cf zt\"]")); //get table class
        List<WebElement> td=table.findElements(By.tagName("tbody")); //make List webelement to store all "tbody" tags
        WebElement emailCheckbox = td.get(0).findElement(By.cssSelector("div[class=\"T-Jo-auh\"]")); //grab first td.get(0) tag
        emailCheckbox.click();

        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]"));
        WebUtil.click(driver,By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]"));
    }
}
