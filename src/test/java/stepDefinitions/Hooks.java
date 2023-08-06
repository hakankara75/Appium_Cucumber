package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import utilities.Driver;

import java.io.IOException;
import java.net.MalformedURLException;

public class Hooks {

    private AppiumDriverLocalService appiumServer=AppiumDriverLocalService.buildDefaultService();
    final Runtime runtime=Runtime.getRuntime();
    @Before
    public void setUp()  {
        forceStopAppiumServer();
        appiumServer.start();
    }

    @After
    public void tearDown(Scenario scenario) throws MalformedURLException {
        final byte[] screenshot= ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
        scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.quitAppiumDriver();
        appiumServer.stop();

    }

    public void forceStopAppiumServer(){
        try {
        runtime.exec("killall node");
        runtime.exec("pkill -i xcodebuild");
            System.out.println("kill all nodes");
        }catch (Exception e) {
        e.printStackTrace();
        }
    }
}
