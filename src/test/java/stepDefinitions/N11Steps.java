package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screens.androidScreen.N11Screen;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.ReusableMethods.waitToBeVisible;

public class N11Steps {
    N11Screen api= new N11Screen();

    @Given("Click on the search box")
    public void clickOnTheSearchBox() {
        waitToBeVisible(api.searchBox, Duration.ofSeconds(20));
        api.searchBox.click();

    }
    @And("Type {string} in the search box")
    public void typeInTheSearchBox(String text) {
        api.searchBox.sendKeys(text);
    }
    @Then("Press on the key {string}")
    public void pressOnTheKey(String arg0) {
    }


}
