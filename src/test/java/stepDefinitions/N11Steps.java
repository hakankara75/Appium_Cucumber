package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.androidScreen.N11Screen;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.ReusableMethods.waitToBeVisible;

public class N11Steps {
    N11Screen api= new N11Screen();
    AndroidDriver driver;

    public N11Steps() throws MalformedURLException {
    }

    @Given("Click on the search box")
    public void clickOnTheSearchBox() throws MalformedURLException {
        waitToBeVisible(api.searchBox, Duration.ofSeconds(30));
        api.searchBox.click();

    }
    @And("Type {string} in the search box")
    public void typeInTheSearchBox(String text) {
        api.searchBar.sendKeys(text);
    }
    @Then("Press on the key {string}")
    public void pressOnTheKey(String key) {
        switch (key) {
            case "Space":
                driver.pressKey(new KeyEvent(AndroidKey.SPACE));
                break;
            case "BackSpace":
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                break;
            case "Enter":
                driver.pressKey(new KeyEvent(AndroidKey.ENTER));
                break;
            default:
                break;
        }
    }


    @Given("Type {string} in the searchbox")
    public void typeInTheSearchbox(String text) throws MalformedURLException {
        waitToBeVisible(api.searchBox, Duration.ofSeconds(20));
        api.searchBox.click();
        api.searchBar.sendKeys(text);
        //api.kulaklikText.click();     //texte tiklayip da aratabiliriz ya da asagidaki enter kodu ile
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Then("Select the firs product")
    public void selectTheFirsProduct() {
        api.firstSelectProduct.click();
    }

    @And("Click on the sepetim")
    public void clickOnTheSepetim() {
        api.sepetim.click();
        api.beyaz.click();
        api.sepeteEkle.click();
        api.secondSepetim.click();

    }

    @And("Verify that {string} is visible")
    public void verifyThatIsVisible(String text) {
        switch (text) {
            case "Ödemeye Geç":
                assertTrue(api.odemeyeGecText.isDisplayed());
                break;
                case "AYNI GÜN TESLİMAT":
                List<WebElement> ayniGunTagList= driver.findElements(ReusableMethods.locateElementByText("AYNI GÜN TESLİMAT"));
                for (WebElement each:ayniGunTagList){
                    assertEquals(each.getText(),"AYNI GÜN TESLİMAT");
                }
                break;
        }

    }

    @Given("Click the {string}")
    public void clickThe(String element) {
       switch (element) {
            case  "Kategoriler":
                api.kategoriler.click();
                break;
            case  "Otomotiv & Motosiklet":
                api.otomotiv.click();
                break;
            case  "Yedek Parça":
                api.yedekParca.click();
                break;
            case  "Egzoz":
                api.egzoz.click();
                break;
            case  "Filtrele":
               api.filtrele.click();
                break;
            case  "Teslimat Adresi Seç":
                api.teslimatAdresi.click();
                break;
            case  "Şehir Seç":
               api.sehirSec.click();
                break;
            case  "İlçe Seç":
                api.ilceSec.click();
                break;
                case  "Sonuçları Göster":
                api.sonuclariGoster.click();
                break;
                case  "Onayla":
               api.onayla.click();
                break;
                case  "İstanbul":
               api.istanbul.click();
                break;
                case  "Beşiktaş":
               api.besiktas.click();
                break;
        }
    }

    @Then("Scroll down to the {string}")
    public void scrollDownToThe(String element) throws MalformedURLException {
        switch (element) {
            case "Huawei":
                ReusableMethods.scrollForMobile(api.firstSelectProduct);
                break;
            case "Qcy":
                ReusableMethods.scrollTo("Qcy T5 Bluetooth 5.1 Kulak İçi Kulaklık");
                break;
                case "İstanbul":
                ReusableMethods.scrollTo("İstanbul");
                break;
                case "Beşiktaş":
                ReusableMethods.scrollTo("Beşiktaş");
                break;
        }
    }

}
