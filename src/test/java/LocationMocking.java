import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LocationMocking extends  TestBase2{
    @Test
    public void mockGeoLocation(){
        Map coordinates = new HashMap()
        {{
            put("Latitude",13.7457);
            put("Longitude",100.5365);
            put("accuracy", 1);
        }};
        chromeDriver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        chromeDriver.get("https://where-am-i.org/");
    }
    @Test
    public void mockGeoLocationCPD(){
        DevTools devTools = chromeDriver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(13.7457),
                Optional.of(100.5365),
                Optional.of(1)));
        chromeDriver.get("https://my-location.org/");
    }
}
