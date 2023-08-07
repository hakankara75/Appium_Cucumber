package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() throws MalformedURLException {
        URL appiumServerUrl =null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (appiumDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities  ();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            capabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability("autoAcceptAlert", true);
            capabilities.setCapability("appium:disableIdLocatorAutocompletion", true);
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6000);
            if (ConfigReader.getProperty("platformName").equals("Android")) {
                capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
                capabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));
                appiumDriver = new AndroidDriver( appiumServerUrl , capabilities);

            } else if (ConfigReader.getProperty("platformName").equals("IOS")) {
                capabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
                appiumDriver = new IOSDriver(appiumServerUrl, capabilities);
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