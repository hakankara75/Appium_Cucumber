package stepDefinitions;

import io.cucumber.java.en.*;
import utilities.Driver;
import utilities.ReusableMethods;

public class AtouMod extends ReusableMethods {

    @Given("Anasayfaya git ve kontrol et")
    public void anasayfaya_git_ve_kontrol_et() throws InterruptedException {
        Driver.getAppiumDriver();
    }

}
