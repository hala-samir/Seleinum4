import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RelativeLocatorTest  extends  TestBase{
    LoginPage login;
    @Test
    public void relativeLocators(){
        login = new LoginPage(driver);
       System.out.println(login.printContent());
    }
    @Test
    public void listOfElements(){
        login = new LoginPage(driver);
        for (WebElement social: login.getSocialList()) {
            System.out.println(social.getAttribute("href"));
        }
    }
}
