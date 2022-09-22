import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public WebElement loginPanel = driver.findElement(By.tagName("h5"));
    public WebElement credentials = driver.findElement(RelativeLocator.with(
            By.className("orangehrm-login-error"))
            .below(loginPanel));
    List<WebElement> allSocialMedia = driver.findElements(RelativeLocator.with(
            By.tagName("a"))
            .below(By.className("orangehrm-login-footer")));
    public String printContent(){
        return credentials.getText();
    }
    public List<WebElement> getSocialList(){
        return allSocialMedia;
    }
}
