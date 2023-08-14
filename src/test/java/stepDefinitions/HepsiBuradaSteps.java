package stepDefinitions;

import io.cucumber.java.en.*;
import screens.androidScreen.HepsiBuradaScreen;
import utilities.Driver;

public class HepsiBuradaSteps {

    HepsiBuradaScreen api=new HepsiBuradaScreen();
    @Given("HepsiBurada uygulamasina gidildi")
    public void hepsi_burada_uygulamasina_gidildi() {
        Driver.getDriver();
    }

    @When("IlkAyaOzel linki tiklandi")
    public void ılk_aya_ozel_linki_tiklandi() {
        api.ilkAyaOzel.click();
    }

}
