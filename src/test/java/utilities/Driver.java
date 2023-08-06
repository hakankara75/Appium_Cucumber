package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() throws MalformedURLException {
        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (appiumDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            capabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability("autoAcceptAlert", true);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
            if (ConfigReader.getProperty("platformName").equals("Android")) {
                capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
                capabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));
                assert appiumServerUrl != null;
                appiumDriver = new AndroidDriver(appiumServerUrl, capabilities);
            } else if (ConfigReader.getProperty("platformName").equals("ios")) {
                capabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
                assert appiumServerUrl != null;
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));

            }
        }
        return appiumDriver;
    }

    public static void quitAppiumDriver(){
        if (appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}