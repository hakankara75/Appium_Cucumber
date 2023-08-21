package stepDefinitions;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.*;
import screens.androidScreen.AtouModScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AtouModSteps extends ReusableMethods {
    static protected AtouModScreen api;

    static {
        try {
            api = new AtouModScreen();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("Anasayfaya git ve kontrol et")
    public void anasayfayaGitVeKontrolEt() throws InterruptedException {


        String ExpectedText = "Vos titres de transport\n" +
                "où et quand vous voulez !";

        assertTrue(api.textTitresDeTransport.getText().contains(ExpectedText));


    }


    @When("Plus tard butonuna tikla")
    public void plusTardButonunaTikla() {

        api.btnPlusTard.click();


    }

    @And("Accepter CGU kontrol et")
    public void accepterCGUKontrolEt() {


        String exptectedTextCGU = "Vous pouvez effectuer des achats jusqu'à 50€, mais pour enregistrer une carte il vous faudra créer un compte.";

        assertThat(api.getTextCGU.getText(), containsString(exptectedTextCGU));


    }


    @And("Accepter CGU tikla")
    public void accepterCGUTikla() {

        api.btnChecked.click();

        if (api.btnOK.isDisplayed()) {
            api.btnOK.click();
        }

    }


    @And("Geolocationu kontol et Ok butonuna tikla")
    public void geolocationuKontolEtOkButonunaTikla() {

        if (api.textGeolocalisation.isDisplayed()) {

            api.btnOKJ.click();
        }


    }

    @And("Harita kullanimina izin ver")
    public void haritaKullaniminaIzinVer() {

        String exptectedTextAutoriser = "Lorsque vous utilisez l'appli";
        assertTrue(api.btnAutoriser.getText().contains(exptectedTextAutoriser));
        api.btnAutoriser.click();
    }


    @And("Daha sonra bak butonuna tikla")
    public void dahaSonraBakButonunaTikla() throws InterruptedException, MalformedURLException {

        TouchAction touchAction = new TouchAction((PerformsTouchActions) Driver.getDriver());
        PointOption point = PointOption.point(620, 2150);
        touchAction.tap(point).perform();


    }

    @Then("Bir hat ekle")
    public void birHatEkle() throws InterruptedException {

        api.searchReseau.click();
        api.searchReseau.sendKeys("Atoumod");


    }
}
