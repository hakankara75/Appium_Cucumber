package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class ViewsSteps extends ReusableMethods {


    @Then("Kullanici Views butonuna tikladi")
    public void kullaniciViewsButonunaTikladi() {
        tapOn( api.viewLink);
    }

    @And("Kullanici Views ekranina geldi")
    public void kullaniciViewsEkraninaGeldi() {
        assertTrue(api.viewLink.isDisplayed());
    }

    @Then("Kullanici drag and drop butonuna tikladi")
    public void kullaniciDragAndDropButonunaTikladi() {
        tapOn(api.dragAndDrop);
    }
    @When("Kullanici birinci topu ikinci topun ustune tikladi")
    public void kullaniciBirinciTopuIkinciTopunUstuneTikladi() {

    }
    @Then("Kullanici dorduncu topu gordu")
    public void kullaniciDorduncuTopuGordu() {
    }

    @And("Screenshot al")
    public void screenshotAl() {
    }
}
