package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepDefinitions.Hooks;

import java.io.IOException;
import java.net.MalformedURLException;

import java.net.Socket;
import java.net.URL;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Driver {
    private static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() throws InterruptedException {

        URL appiumServerURL = null;

        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        if (appiumDriver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConfigReader.getProperty("appPackage"));
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConfigReader.getProperty("appActivity"));
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            if (ConfigReader.getProperty("platformName").equals("Android")) {
                appiumDriver = new AndroidDriver(appiumServerURL, caps);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {

                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));

            }

        }

        return appiumDriver;
    }
}


//    public static AppiumDriver appiumDriver;
//
//    public static AppiumDriver getAppiumDriver() throws InterruptedException {
//        int port = 4723;
//        System.out.println("isAppiumServerRunning(\"localhost\", port) = " + isAppiumServerRunning("localhost", port));
//        URL appiumServerURL = null;
//
//        try {
//            appiumServerURL = new URL("http://127.0.0.1:4723/");
//        } catch (MalformedURLException var5) {
//            var5.printStackTrace();
//        }
//
//        if (appiumDriver == null) {
//            System.out.println("cap atamalari basladi mi");
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//            desiredCapabilities.setCapability("automationName", ConfigReader.getProperty("automationName"));
//            desiredCapabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
//            desiredCapabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
//            desiredCapabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
//            desiredCapabilities.setCapability("app", ConfigReader.getProperty("appPath"));
//            desiredCapabilities.setCapability("noReset", true);
//            desiredCapabilities.setCapability("newCommandTimeout", "60000");
//            desiredCapabilities.setCapability("shouldTerminateApp", true);
//            System.out.println("desiredCapabilities = " + desiredCapabilities);
//            if (ConfigReader.getProperty("platformName").equals("android")) {
//                desiredCapabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
//                desiredCapabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));
//                Thread.sleep(8000L);
//
//                assert appiumServerURL != null;
//
//                try {
//                    System.out.println("buradabaslatmaya calisyoruz");
//                    Thread.sleep(5000L);
//                    appiumDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);
//                    appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
//                    System.out.println("appiumDrivertrtrt = " + appiumDriver);
//                } catch (Exception var4) {
//                    System.out.println("Driver Baslatilamadi");
//                }
//            } else {
//                if (!ConfigReader.getProperty("platformName").equals("iOS")) {
//                    throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
//                }
//
//                desiredCapabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
//
//                assert appiumServerURL != null;
//
//                appiumDriver = new IOSDriver(Hooks.appiumServer.getUrl(), desiredCapabilities);
//            }
//        }
//
//        return appiumDriver;
//    }
//
//    public static boolean isAppiumServerRunning(String host, int port) {
//        try {
//            Socket socket = new Socket(host, port);
//
//            boolean var3;
//            try {
//                var3 = true;
//            } catch (Throwable var6) {
//                try {
//                    socket.close();
//                } catch (Throwable var5) {
//                    var6.addSuppressed(var5);
//                }
//
//                throw var6;
//            }
//
//            socket.close();
//            return var3;
//        } catch (IOException var7) {
//            return false;
//        }
//    }
//}
