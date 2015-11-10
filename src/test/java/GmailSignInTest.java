import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mo_brian on 11/9/15.
 */
public class GmailSignInTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void gmailLoginShouldBeSuccessful(){

        //Go to Gmail Website

        driver.get("http://gmail.com");
        //Fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("seleniumtest915@gmail.com");
        WebElement clickNext = driver.findElement(By.id("next"));
        clickNext.click();
        //fill in password
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement passwordTextbox = driver.findElement(By.name("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("selenium123");
        WebElement checkbox = driver.findElement(By.id("PersistentCookie"));
        checkbox.click();
        //click sign in
        WebElement signIn = driver.findElement(By.id("signIn"));
        signIn.click();
        //verify user is signed in

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.partialLinkText("Inbox"))));

        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        //sign out
        WebElement profile = driver.findElement(By.cssSelector("span[class=\"gb_Ka gbii\"]"));
        profile.click();

        WebElement signOut = driver.findElement(By.id("gb_71"));
        signOut.click();
        //verify user is signed out

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"Email\"]")));
        Assert.assertTrue("Next button should exist", driver.findElements(By.cssSelector("input[id=\"Email\"]")).size() > 0);




    }
    @Test
    public void sendAndReceiveEmail() {
        //click sign in
        driver.get("http://gmail.com");
        //Fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("seleniumtest915@gmail.com");
        WebElement clickNext = driver.findElement(By.id("next"));
        clickNext.click();
        //fill in password
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

        WebElement passwordTextbox = driver.findElement(By.name("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("selenium123");
        WebElement checkbox = driver.findElement(By.id("PersistentCookie"));
        checkbox.click();
        //click sign in
        WebElement signIn = driver.findElement(By.id("signIn"));
        signIn.click();
        //verify user is signed in

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

        //click compose

        WebElement compose = driver.findElement(By.cssSelector("div[role=\"button\"][class=\"T-I J-J5-Ji T-I-KE L3\"]"));
        compose.click();
        //fill in recipient

        WebElement recipient = driver.findElement(By.cssSelector("textarea[name=\"to\"]"));
        recipient.clear();
        final String recipientEmail = "seleniumtest915@gmail.com";
        recipient.sendKeys(recipientEmail);
        //fill in subject

        WebElement subject = driver.findElement(By.cssSelector("input[name=\"subjectbox\"]"));
        subject.clear();
        final String subjectText = "Gmail send Email test";
        subject.sendKeys(subjectText);

        //fill in body
        WebElement body = driver.findElement(By.cssSelector("div[aria-label=\"Message Body\"]"));
        body.clear();
        final String bodyText = "This is the body of the Test Email.";
        body.sendKeys(bodyText);
        //click send

        WebElement send = driver.findElement(By.cssSelector("div[role=\"button\"][aria-label*=\"Send\"]"));
        send.click();
        //click inbox
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox (1)")));
        WebElement inbox = driver.findElement(By.partialLinkText("Inbox (1)"));
        inbox.click();

        //click email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"y6\"] span[id] b")));
        WebElement clickEmail = driver.findElement(By.cssSelector("div[class=\"y6\"] span[id] b"));
        clickEmail.click();

        //verify email subject and body is correct

        WebElement verifySubject = driver.findElement(By.cssSelector("div[class=\"ha\"] h2[id]"));
        Assert.assertEquals("Subject should equal", subjectText, verifySubject.getText());

        WebElement verifyBody = driver.findElement(By.cssSelector("div[class=\"a3s\"] div[dir=\"ltr\"]"));
        Assert.assertEquals("Body should equal", bodyText, verifyBody.getText());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        WebElement inboxZero = driver.findElement(By.partialLinkText("Inbox"));
        inboxZero.click();

        //delete email


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div [class=\"F cf zt\"]")));
        WebElement table = driver.findElement(By.cssSelector("div [class=\"F cf zt\"]")); //get table class
        List<WebElement> td=table.findElements(By.tagName("tbody")); //make List webelement to store all "tbody" tags
        WebElement emailCheckbox = td.get(0).findElement(By.cssSelector("div[class=\"T-Jo-auh\"]")); //grab first td.get(0) tag
        emailCheckbox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]")));
        WebElement deleteEmail = driver.findElement(By.cssSelector("div[class=\"ar9 T-I-J3 J-J5-Ji\"]"));
        deleteEmail.click();
        //sign out

        WebElement profile = driver.findElement(By.cssSelector("span[class=\"gb_Ka gbii\"]"));
        profile.click();

        WebElement signOut = driver.findElement(By.id("gb_71"));
        signOut.click();

        //verify user is signed out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"Email\"]")));
        Assert.assertTrue("Next button should exist", driver.findElements(By.cssSelector("input[id=\"Email\"]")).size() > 0);


    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
