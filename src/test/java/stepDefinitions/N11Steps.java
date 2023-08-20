package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import screens.androidScreen.N11Screen;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.driver;
import static utilities.ReusableMethods.waitToBeVisible;

public class N11Steps {
    N11Screen api= new N11Screen();
    AndroidDriver driver;

    @Given("Click on the search box")
    public void clickOnTheSearchBox() {
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


}
