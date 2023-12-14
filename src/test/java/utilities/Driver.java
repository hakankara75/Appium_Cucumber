package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class Driver {


    public static AppiumDriver driver;
    public static AppiumDriver getDriver() {

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


//    public static AppiumDriver getDriver() {
//
//        if (driver == null) {
//
//            switch (ConfigReader.getProperty("platformName")) {
//                case "Android":
//                    options = new UiAutomator2Options();
//                    options.setApp(ConfigReader.getProperty("app"));
////                    options.setAppPackage("com.touchboarder.android.api.demos");  //Uygulama paketi adini ayarlar
////                    options.setAppActivity("com.touchboarder.androidapidemos.MainActivity"); //Uygulama aktivite adini ayarla
//                    options.setDeviceName(ConfigReader.getProperty("device"));    //Cihaz UDID'sini ayarla bu kodu cmd'de "adb devices" yazarak buluruz
//                    options.setNoReset(true);   //sifirlama islemini kapat
//                    options.setCapability("shouldTerminateApp", true);   // appi kapatmak için
//                    options.setNewCommandTimeout(Duration.ofSeconds(15));   //yeni komut zaman asimini ayarla
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
//                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//                    driverCreated = true;
//                    System.out.println("Android baglandi, driver atandi");
//                } catch (MalformedURLException ignored) {
//
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
}


