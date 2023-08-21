package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Driver {

    private static UiAutomator2Options options;
    public static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {

            if (driver == null) {
                switch (ConfigReader.getProperty("platformName")) {
                    case "Android":
                        //UiAutomator2Options objesi olustur
                        options = new UiAutomator2Options();
                        //Uygulama paketi adini ayarlar
                        options.setAppPackage(ConfigReader.getProperty("appPackage"));
                        //Uygulama aktivite adini ayarla
                        options.setAppActivity(ConfigReader.getProperty("appActivity"));
                        //Cihaz UDID'sini ayarla
                        options.setUdid(ConfigReader.getProperty("setUdid")); //bu kodu cmd'de "adb devices" yazarak buluruz
                        //sifirlama islemini kapat
                        options.setNoReset(true);
                        //yeni komut zaman asimini ayarla
                        options.setNewCommandTimeout(Duration.ofSeconds(20));
                        options.setCapability("shouldTerminateApp", true);//aplication kapatmak icin
                        break;
                    case "IOS":
                        //IOS icin konfigurasyonlar buraya yazilir
                        break;
                    default:
                        //hata mesajiyla birlikte bir runtime exception firlat
                        throw new RuntimeException("Desteklenmeyen platform: " + ConfigReader.getProperty("platformName"));
                }


                boolean driverCreated = false;
                int maxAttempts = 5;
                int attempt = 0;

                do {
                    System.out.println("Deneme #" + (attempt + 1));
                    driver = new AndroidDriver(new URL("http://127.0.0.2:4723/"),options);
                    driverCreated = true;
                    System.out.println("Android baglandi, driver atandi");

                    if (!driverCreated) {
                        System.out.println("Bekleme ve yeniden deneme...");
                        attempt++;
                        if (attempt >= maxAttempts) {
                            throw new RuntimeException("Belirtilen sayida deneme yapildi, driver olusturulamadi.");
                        }
                        // Gerekirse bir bekleme süresi ekleyebilirsiniz.
                        // Thread.sleep(2000);
                    }
                } while (!driverCreated);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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


//    private static AppiumDriver appiumDriver;
//
//    public static AppiumDriver getDriver() {
//
//        URL appiumServerURL = null;
//
//        try {
//            appiumServerURL = new URL("http:0.0.0.0:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//        if (appiumDriver ==null){
//
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,ConfigReader.getProperty("automationName"));
//            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,ConfigReader.getProperty("platformName"));
//            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,ConfigReader.getProperty("platformVersion"));
//            caps.setCapability(MobileCapabilityType.DEVICE_NAME,ConfigReader.getProperty("deviceName"));
//            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,ConfigReader.getProperty("appPackage"));
//            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,ConfigReader.getProperty("appActivity"));
//
//
//
//            if (ConfigReader.getProperty("platformName").equals("Android")) {
//                appiumDriver = new AndroidDriver(appiumServerURL,caps);
//                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            }else {
//
//                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
//
//            }
//
//        }
//
//        return appiumDriver;
//    }
//
//
//    public static void quitAppiumDriver(){
//        if (appiumDriver != null) {
//            appiumDriver.quit();
//            appiumDriver = null;
//        }
//    }

}

