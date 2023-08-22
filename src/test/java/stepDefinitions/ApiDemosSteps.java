package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.time.Duration;

import static java.time.Duration.*;
import static org.junit.Assert.*;
import static utilities.Driver.driver;

public class ApiDemosSteps extends ReusableMethods {

    @Given("Application yuklendi")
    public void application_yuklendi() throws MalformedURLException, InterruptedException {


    }
    @When("Kullanici anasayfaya geldi")
    public void kullanici_anasayfaya_geldi() throws MalformedURLException, InterruptedException {
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//      WebElement apiTitle= wait.until(ExpectedConditions.visibilityOfElementLocated((By) api.apiTitle));

  assertTrue(api.apiTitle.isDisplayed());
    }
    @When("Kullanici Api Demos butonuna tikladi")
    public void kullanici_api_demos_butonuna_tikladi() {

    }
    @Then("Kullanici Api Demos ekranina geldi")
    public void kullanici_api_demos_ekranina_geldi() {

    }
    @Then("Kullanici Preference linkine tikladi")
    public void kullanici_preference_linkine_tikladi() {
     //   tapOn(api.preference);
    }
    @Then("Kullanici Preference ekranina geldi")
    public void kullanici_preference_ekranina_geldi() {
     //   assertTrue(api.preferenceArea.isDisplayed());
    }
    @Then("Kullanici Preference Dependencies linkine tikladi")
    public void kullanici_preference_dependencies_linkine_tikladi() {
     //   tapOn(api.preferenceDependencies);
    }
    @Then("Kullanici wifi check boxi secti")
    public void kullanici_wifi_check_boxi_secti() {
     //   if (api.wifiCheckBox.isSelected()) {

    //   }else {
     //       tapOn(api.wifiCheckBox);
      //  }
    }
    @Then("Kullanici wifi settingsi tikladi")
    public void kullanici_wifi_settingsi_tikladi() {
        //tapOn(api.wifiSettings);
    }
    @Then("Wifi settings popup goruldu")
    public void wifi_settings_popup_goruldu() {
        //assertTrue(api.wifiSettingsPopup.isDisplayed());
    }
    @Then("kullanici {string} yazdi")
    public void kullanici_yazdi(String string) {
        //enterText(api.wifiSettingsTextBox, string,true);
    }
    @Then("kullanici OK butonuna tikladi")
    public void kullanici_ok_butonuna_tikladi() {
       //tapOn(api.okButton);
    }


    @And("Switch linkini tikladi")
    public void switchLinkiniTikladi() {
        //tapOn(api.switchButton);
    }

    @Then("CheckBox Preference boxa tikladi")
    public void checkboxPreferenceBoxaTikladi() {
       // tapOn(api.checkBox);
    }

    @And("Switch preference secildi")
    public void switchPreferenceSecildi() {
        //tapOn(api.switchPreference);
    }
}
