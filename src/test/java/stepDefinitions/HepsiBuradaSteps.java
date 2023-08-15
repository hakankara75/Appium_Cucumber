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

    @When("Kategoriler linki tiklandi")
    public void kategorilerLinkiTiklandi() {
        System.out.println("kategriler linki tiklandi");
            api.kategoriler.click();
        }

    }
