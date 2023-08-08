package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
        runtime.exec("taskkill /F /IM node.exe");
        runtime.exec("taskkill /F /IM cmd.exe");
            System.out.println("kill all nodes");
        }catch (Exception e) {
        e.printStackTrace();
        }
    }
}
