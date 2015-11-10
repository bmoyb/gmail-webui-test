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

    @After
    public void tearDown(){
        driver.quit();
    }
}
