import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));

    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
//    @Test
//    public void test1(){
//         WebElement loginPanel = driver.findElement(By.tagName("h5"));
//         WebElement cridentials = driver.findElement(RelativeLocator.with(
//                        By.className("orangehrm-login-error"))
//                .below(loginPanel));
//        System.out.println(cridentials.getText());
//    }
}
