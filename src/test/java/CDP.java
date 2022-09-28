import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.Test;

public class CDP extends  TestBase2{
    @Test
    public void viewBrowserConsoleLogs(){
    DevTools devTools = chromeDriver.getDevTools();
    devTools.createSession();
    devTools.send(Log.enable());
    devTools.addListener(Log.entryAdded(), logEntry -> {
        System.out.println("..........");
        System.out.println("level: "+logEntry.getLevel());
        System.out.println("text:"+logEntry.getText());
        System.out.println("url"+logEntry.getUrl());
    });
    chromeDriver.get("http://the-internet.herokuapp.com/broken_images");
    }
}
