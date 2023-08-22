package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

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

//    public UiAutomator2Options options;
//    public static AppiumDriver driver;
//    public AppiumDriver getDriver() {
//
//        if (driver == null) {
//
//            switch (ConfigReader.getProperty("platformName")) {
//                case "Android ":
//                    options = new UiAutomator2Options();
//                    options.setAppPackage(ConfigReader.getProperty("appPackage"));  //Uygulama paketi adini ayarlar
//                    options.setAppActivity(ConfigReader.getProperty("appActivity")); //Uygulama aktivite adini ayarla
//                    options.setUdid(ConfigReader.getProperty("setUdid"));    //Cihaz UDID'sini ayarla bu kodu cmd'de "adb devices" yazarak buluruz
//                    options.setNoReset(true);   //sifirlama islemini kapat
//                    options.setCapability("shouldTerminateApp",true);   // appi kapatmak için
//                    options.setNewCommandTimeout(Duration.ofSeconds(20));   //yeni komut zaman asimini ayarla
//                    break;
//                case "IOS":
//                    // IOS için ayarlar
//                    break;
//                default:
//                    throw new RuntimeException("Desteklenmeyen Platform: " + ConfigReader.getProperty("platformName"));
//            }
//
//            boolean driverCreated = false;
//            int maxAttempts = 5;
//            int attempt = 0;
//
//            do {
//                try {
//                    System.out.println("Deneme #" + (attempt + 1));
//                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
//                    driverCreated = true;
//                    System.out.println("Android baglandi, driver atandi");
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                }
//
//                if (!driverCreated) {
//                    System.out.println("Bekleme ve yeniden deneme...");
//                    attempt++;
//                    if (attempt >= maxAttempts) {
//                        throw new RuntimeException("Belirtilen sayida deneme yapildi, driver olusturulamadi.");
//                    }
//                    // Gerekirse bir bekleme süresi ekleyebilirsiniz.
//                    // Thread.sleep(2000);
//                }
//            } while (!driverCreated);
//
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        }
//        return driver;
//    }
//
//    public static boolean isAppiumServerRunning(String host, int port) {
//        try (Socket socket = new Socket(host, port)) {
//            return true;
//        } catch (IOException e) {
//            return false;
//        }
//    }
//
//    public static void quitAppiumDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

    public static AppiumDriver driver;


    public static AppiumDriver getDriver() {

        int port = 4723;
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (driver == null) {


            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            //desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
            desiredCapabilities.setCapability("shouldTerminateApp", true);

            System.out.println("desiredCapabilities = " + desiredCapabilities);
            if (ConfigReader.getProperty("platformName").equals("Android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"

                desiredCapabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
                desiredCapabilities.setCapability("appActivity", "com.hepsiburada.android.hepsix.library.MainActivity");

                assert appiumServerURL != null;

                do{
                    System.out.println("buradabaslatmaya calisyoruz");

                    driver = new AppiumDriver(appiumServerURL, desiredCapabilities);
                   // WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    System.out.println("appiumDrivertrtrt = " + driver);
                    System.out.println("Driver Baslatilamadi");
                }while (driver==null);
            } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
                //if you do not provide app path so you should use "bundleId"
                desiredCapabilities.setCapability("bundleId", ConfigReader.getProperty("iosBundleId"));
                assert appiumServerURL != null;
                driver = new IOSDriver(appiumServer.getUrl(), desiredCapabilities);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
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
}


