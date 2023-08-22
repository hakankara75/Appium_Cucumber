package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import screens.androidScreen.HepsiBuradaScreen;
import utilities.Driver;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.Assert.*;
import static utilities.Driver.*;
import static utilities.ReusableMethods.scroll;
import static utilities.ReusableMethods.waitToBeVisible;

public class HepsiBuradaSteps extends Driver{

    HepsiBuradaScreen api=new HepsiBuradaScreen();

    public HepsiBuradaSteps() throws MalformedURLException {
    }

    @Given("HepsiBurada uygulamasina gidildi")
    public void hepsi_burada_uygulamasina_gidildi() throws MalformedURLException {
        getDriver();
    }

    @When("Kategoriler linki tiklandi")
    public void kategorilerLinkiTiklandi() throws MalformedURLException {
        waitToBeVisible(api.kategoriler,Duration.ofSeconds(20));
        api.kategoriler.click();
        }
    @And("Kategoriler bolumunde olundugu dogrulandi")
    public void kategorilerBolumundeOlunduguDogrulandi() {
        assertTrue(api.kategorilerBaslik.isDisplayed());
    }
    @Then("Spor Giyim linki tiklandi")
    public void sporGiyimLinkiTiklandi() {
        api.sporGiyim.click();
    }

    @And("Spor Giyim bolumunde olundugu dogrulandi")
    public void sporGiyimBolumundeOlunduguDogrulandi() throws InterruptedException, MalformedURLException {
        assertTrue(api.sporGiyimBaslik.isDisplayed());

        scroll(driver,1);
    }


}
