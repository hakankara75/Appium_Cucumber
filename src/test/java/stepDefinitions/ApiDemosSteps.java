package stepDefinitions;

import io.cucumber.java.en.*;
import screens.androidScreen.ApiDemosScreen;
import utilities.Driver;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class ApiDemosSteps {

    ApiDemosScreen api=new ApiDemosScreen();
    @Given("Application yuklendi")
    public void application_yuklendi() throws MalformedURLException {
        Driver.getAppiumDriver();
    }
    @When("Kullanici anasayfaya geldi")
    public void kullanici_anasayfaya_geldi() {
      assertTrue(api.apiTitle.getText().contains("API"));
    }
    @When("Kullanici Api Demos butonuna tikladi")
    public void kullanici_api_demos_butonuna_tikladi() {

    }
    @Then("Kullanici Api Demos ekranina geldi")
    public void kullanici_api_demos_ekranina_geldi() {

    }
    @Then("Kullanici Preference linkine tikladi")
    public void kullanici_preference_linkine_tikladi() {
        api.preference.click();
    }
    @Then("Kullanici Preference ekranina geldi")
    public void kullanici_preference_ekranina_geldi() {
        assertTrue(api.preferenceArea.isDisplayed());
    }
    @Then("Kullanici Preference Dependencies linkine tikladi")
    public void kullanici_preference_dependencies_linkine_tikladi() {
        api.preferenceDependencies.click();
    }
    @Then("Kullanici wifi check boxi secti")
    public void kullanici_wifi_check_boxi_secti() {
        if (api.wifiCheckBox.isSelected()) {

        }else {
            api.wifiCheckBox.click();
        }
    }
    @Then("Kullanici wifi settingsi tikladi")
    public void kullanici_wifi_settingsi_tikladi() {
        api.wifiSettings.click();
    }
    @Then("Wifi settings popup goruldu")
    public void wifi_settings_popup_goruldu() {
        assertTrue(api.wifiSettingsPopup.isDisplayed());
    }
    @Then("kullanici {string} yazdi")
    public void kullanici_yazdi(String string) {
        api.wifiSettingsTextBox.sendKeys(string);
    }
    @Then("kullanici OK butonuna tikladi")
    public void kullanici_ok_butonuna_tikladi() {
       api.okButton.click();
    }


}
