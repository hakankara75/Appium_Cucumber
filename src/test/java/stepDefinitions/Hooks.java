package stepDefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;



public class Hooks {

    private AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();
    final Runtime runtime = Runtime.getRuntime();
    @Before
    public void setUp(){
        //it starts appium server

        appiumServer.start();

    }
    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }



    }
}