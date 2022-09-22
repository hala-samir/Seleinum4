import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    public WebDriver driver;
    public  JavascriptExecutor js;
    //constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickBtn(WebElement btn) {
        btn.click();
    }

    public void scrollDown(){
        js.executeScript("window.scrollBy(0,2500)");
    }
}

