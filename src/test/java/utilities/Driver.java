package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class Driver {

    private static UiAutomator2Options options;
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {

            if (driver == null) {
                switch (ConfigReader.getProperty("platformName")) {
                    case "Android":
                        //UiAutomator2Options objesi olustur
                        options = new UiAutomator2Options();
                        //Uygulama paketi adini ayarlar
                        options.setAppPackage("com.pozitron.hepsiburada");
                        //Uygulama aktivite adini ayarla
                        options.setAppActivity("com.hepsiburada.ui.home.BottomNavigationActivity");
                        //Cihaz UDID'sini ayarla
                        options.setUdid("R68T2013J2Y"); //bu kodu cmd'de "adb devices" yazarak buluruz
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
                    try {
                        System.out.println("Deneme #" + (attempt + 1));
                        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
                        driverCreated = true;
                        System.out.println("Android baglandi, driver atandi");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }

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

}

