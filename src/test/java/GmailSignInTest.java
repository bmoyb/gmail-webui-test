import com.appsenseca.categories.Critical;
import com.appsenseca.categories.Major;
import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.EmailViewPage;
import com.appsenseca.pageobjects.SignInPage;
import com.appsenseca.util.WebUtil;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mo_brian on 11/9/15.
 */
public class GmailSignInTest {
    WebDriver driver;
    @Before
    public void setDriver(){
        String browserName = System.getenv("browser");
        if(browserName != null && browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else {
            driver = new FirefoxDriver();
        }
    }

    @Category({Critical.class})
    @Test
    public void gmailLoginShouldBeSuccessful(){

        //Go to Gmail Website
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        //Fill in username
        signInPage.fillInUsername(driver,"seleniumtest915@gmail.com" );
        //fill in password
        signInPage.fillInPassword(driver, "selenium123");
        //click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);
        //verify user is signed in
        Assert.assertTrue("Inbox should exist", EmailHomePage.isElementExist(driver));
        //sign out
        signInPage = emailHomePage.signOut(driver);
        //verify user is signed out
        Assert.assertTrue("Next button should exist", signInPage.isElementExist(driver));

    }
    @Category({Major.class})
    @Test
    public void sendAndReceiveEmail() {
        //click sign in
        SignInPage signInPage = WebUtil.goToSignInPage(driver);
        //Fill in username
        signInPage.fillInUsername(driver,"seleniumtest915@gmail.com" );
        //fill in password
        signInPage.fillInPassword(driver, "selenium123");
        //click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);
        //verify user is signed in
        Assert.assertTrue("Inbox should exist", emailHomePage.isElementExist(driver));
        //click compose
        emailHomePage.composeEmail(driver);
        //fill in recipient
        emailHomePage.fillRecipient(driver, "seleniumtest915@gmail.com");
        //fill in subject
        final String subjectText = "Gmail send Email test";
        emailHomePage.fillSubject(driver, subjectText);
        //fill in body
        final String bodyText = "This is the body of the Test Email.";
        emailHomePage.fillBody(driver, bodyText);
        //click send
        emailHomePage.hitSend(driver);
        //click inbox
        emailHomePage.refreshInbox(driver);
        //open email
        EmailViewPage emailViewPage = emailHomePage.openEmail(driver);
        //verify email subject and body is correct
        String actualSubject = emailViewPage.getEmailSubject(driver);
        Assert.assertEquals("Subject should equal", subjectText, actualSubject);

        String actualBody = emailViewPage.getEmailBody(driver);
        Assert.assertEquals("Body should equal", bodyText, actualBody);

        emailHomePage.refreshInbox(driver);
        //delete email
        emailHomePage.deleteNewestEmail(driver);
        //sign out
        signInPage = emailHomePage.signOut(driver);
        //verify user is signed out
        Assert.assertTrue("Next button should exist", signInPage.isElementExist(driver));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
