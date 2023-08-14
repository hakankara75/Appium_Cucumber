package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HepsiBuradaScreen extends ApiDemosScreen{

    //UiSelector ile locate alirken kalip "new UiSelector().className("android.widget.ImageView").instance(13)"
    @AndroidFindBy (uiAutomator = "className(\"android.widget.ImageView\").instance(13)")
    public WebElement ilkAyaOzel;
}
