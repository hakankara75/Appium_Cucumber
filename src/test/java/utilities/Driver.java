package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static runner.Hooks.appiumServer;


public class Driver {

    public UiAutomator2Options options;
    public static AppiumDriver driver;
    public AppiumDriver getDriver() {

        AppiumDriver driver = null;

        // DesiredCapabilities ayarları
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\HakanBatirhan\\IdeaProjects\\Appium_Cucumber\\src\\Apps\\hepsiburada.apk");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");

        try {
            // Appium sunucusuna bağlantı URL'si
            URL appiumServerURL = new URL("http://127.0.0.1:4723/");

            // AndroidDriver nesnesini başlat
            driver = new AndroidDriver(appiumServerURL, capabilities);

            // Bağlantı başarılı mesajı
            System.out.println("Appium sunucusuna başarıyla bağlandı.");
        } catch (Exception e) {
            System.err.println("Bağlantı hatası: " + e.getMessage());
        }

        return driver;
    }

    public static boolean isAppiumServerRunning(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    public static AppiumDriver driver;
//
//
//    public static AppiumDriver getDriver() {
//
//        int port = 4723;
//        URL appiumServerURL = null;
//        try {
//            appiumServerURL = new URL("http://127.0.0.1:4723/");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        if (driver == null) {
//
//
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
//            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
//            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
//            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
//            //desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
//            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
//            desiredCapabilities.setCapability("shouldTerminateApp", true);
//
//            System.out.println("desiredCapabilities = " + desiredCapabilities);
//            if (ConfigReader.getProperty("platformName").equals("Android")) {
//                //if you do not provide app path so you should provide "appPackage" and "appActivity"
//
//                desiredCapabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
//                desiredCapabilities.setCapability("appActivity", "com.hepsiburada.android.hepsix.library.MainActivity");
//
//                assert appiumServerURL != null;
//
//                do{
//                    System.out.println("buradabaslatmaya calisyoruz");
//                    driver = new AppiumDriver(appiumServerURL, desiredCapabilities);
//                   WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//                    System.out.println("appiumDrivertrtrt = " + driver);
//                    System.out.println("Driver Baslatilamadi");
//                }while (driver==null);
//            } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
//                //if you do not provide app path so you should use "bundleId"
//                desiredCapabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
//                assert appiumServerURL != null;
//                driver = new IOSDriver(appiumServer.getUrl(), desiredCapabilities);
//            } else {
//                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
//            }
//        }
//        return driver;
//    }
//    }
}


