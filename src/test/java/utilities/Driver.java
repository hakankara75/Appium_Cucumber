package utilities;


import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.ios.IOSDriver;
        import io.appium.java_client.remote.MobileCapabilityType;
        import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;

import static stepDefinitions.Hooks.appiumServer;


public class Driver {
    public static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() throws InterruptedException {

        int port = 4723;

        System.out.println("isAppiumServerRunning(\"localhost\", port) = " + isAppiumServerRunning("localhost", port));


        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {

            System.out.println("cap atamalari basladi mi");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            // desiredCapabilities.setCapability("autoAcceptAlert", true);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
            desiredCapabilities.setCapability("shouldTerminateApp", true);

            System.out.println("desiredCapabilities = " + desiredCapabilities);
            if (ConfigReader.getProperty("platformName").equals("android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"

                desiredCapabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
                desiredCapabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
                Thread.sleep(8000);
                assert appiumServerURL != null;
                try {
                    System.out.println("buradabaslatmaya calisyoruz");
                    Thread.sleep(5000);
                    appiumDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);
                    appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    System.out.println("appiumDrivertrtrt = " + appiumDriver);
                } catch (Exception e) {
                    System.out.println("Driver Baslatilamadi");
                }
            } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
                //if you do not provide app path so you should use "bundleId"
                desiredCapabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
                assert appiumServerURL != null;
                appiumDriver = new IOSDriver(appiumServer.getUrl(), desiredCapabilities);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
        }
        return appiumDriver;
    }





    public static boolean isAppiumServerRunning(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }

    }

}