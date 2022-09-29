import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.network.Network;
import org.openqa.selenium.devtools.v102.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkMocking extends TestBase2{

    @Test
    public void mockNetwork(){
        DevTools devTools = chromeDriver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                150,
                2500,
                2000,
                Optional.of(ConnectionType.CELLULAR2G)));
        chromeDriver.get("https://www.google.com");
        System.out.println("Slow network "+chromeDriver.getTitle());
    }
    @Test
    public void notEnableSlowNetwork(){
        chromeDriver.get("https://www.google.com");
        System.out.println("Don't enable network "+ chromeDriver.getTitle());
    }
}
