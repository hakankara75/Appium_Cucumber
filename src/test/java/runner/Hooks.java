package runner;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.time.Duration;

import static utilities.Driver.driver;
import static utilities.Driver.isAppiumServerRunning;


public class Hooks {
    public static AppiumDriverLocalService appiumServer; //= AppiumDriverLocalService.buildDefaultService();

    @Before
    public void setUp() throws InterruptedException {
        //it starts appium server
        forceStopAppiumServer();
        do {
            AppiumServiceBuilder builder = new AppiumServiceBuilder();
            builder
                    //   .withAppiumJS(new File("C:/Users/Hakan Batirhan.DESKTOP-KA8SOKR/node_modules/appium/build/lib/main.js"))  APPIUM YOLU İÇİN
                    // .usingDriverExecutable(new File("C:/ProgramData/Microsoft/Windows/Start Menu/Programs/Node.js"))
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withTimeout(Duration.ofSeconds(30));

                appiumServer = AppiumDriverLocalService.buildService(builder);

                appiumServer.start();


        } while (!(isAppiumServerRunning("localhost", 4723)));

        System.out.println("server started");

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }

    }

    public void forceStopAppiumServer() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM node.exe");
            Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
