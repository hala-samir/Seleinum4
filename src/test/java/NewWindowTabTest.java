import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindowTabTest extends TestBase{
    SigninPage signinPageObj;

    @Test
    public void windowTabTest(){
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.navigate().to("http://automationpractice.com/index.php");
        System.out.println("Title: "+driver.getTitle());
    }
    @Test
    public void switchBetweenWindows(){
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("title tab 1 " +driver.getTitle());
        signinPageObj = new SigninPage(driver);
        signinPageObj.enterEmail("test123@email.com");
        signinPageObj.clickSignin();
        Set<String> allWindowTabs = driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabs.iterator();
        String mainFirstWindow = iterate.next();
        driver.switchTo().window(mainFirstWindow);
        System.out.println("first tab"+driver.getTitle());
    }
    @Test
    public void getRectOfLogo(){
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPageObj = new SigninPage(driver);
        Rectangle rect = signinPageObj.logo.getRect();
        System.out.println("Width = "+ rect.getWidth());
        System.out.println("Height = "+ rect.getHeight());
        System.out.println("X = "+ rect.getX());
        System.out.println("Y = "+ rect.getY());
    }

    @Test
    public void logoScreenshot() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPageObj = new SigninPage(driver);
        File source =  signinPageObj.logo.getScreenshotAs(OutputType.FILE);
        File destination = new File("logo.png");
        FileHandler.copy(source,destination);
    }
    @Test
    public void sectionScreenshot() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPageObj = new SigninPage(driver);
        File source =  signinPageObj.header.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("header.png"));
    }
    @Test
    public void fullpageScreenshot() throws IOException {
        driver.switchTo().newWindow(WindowType.TAB).get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPageObj = new SigninPage(driver);
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("fullPageScreenshot.png"));
    }

}
