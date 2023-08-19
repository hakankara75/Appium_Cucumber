package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.androidScreen.HepsiBuradaScreen;
import utilities.Driver;

import java.time.Duration;

public class HepsiBuradaSteps {

    HepsiBuradaScreen api=new HepsiBuradaScreen();
    @Given("HepsiBurada uygulamasina gidildi")
    public void hepsi_burada_uygulamasina_gidildi() {
        Driver.getDriver();
    }

    @When("Kategoriler linki tiklandi")
    public void kategorilerLinkiTiklandi() {
        System.out.println("kategriler linki tiklandi");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        WebElement kategoriler= wait.until(ExpectedConditions.visibilityOfElementLocated((By) api.kategoriler));

        kategoriler.click();
        }

    }
