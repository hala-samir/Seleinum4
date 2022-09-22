import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage extends PageBase{
    public SigninPage(WebDriver driver) {
        super(driver);
    }
    WebElement emailField = driver.findElement(By.id("email_create"));
    WebElement signinBtn = driver.findElement(By.id("SubmitCreate"));
    public WebElement logo = driver.findElement(By.cssSelector(".logo.img-responsive"));
    public WebElement header = driver.findElement(By.xpath("//header/div[3]/div[1]"));

    public void enterEmail(String emailAddress){
        emailField.sendKeys(emailAddress);
    }

    public void clickSignin(){
        signinBtn.click();
    }
}
