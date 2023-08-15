package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HepsiBuradaScreen extends ApiDemosScreen{

    //UiSelector ile locate alirken kalip "new UiSelector().className("android.widget.ImageView").instance(13)"
    @AndroidFindBy (uiAutomator = "className(\"android.widget.TextView\").instance(1)")
    public WebElement kategoriler;
}
