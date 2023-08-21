package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class HepsiBuradaScreen extends ApiDemosScreen{

    //UiSelector ile locate alirken kalip "new UiSelector().className("android.widget.ImageView").instance(13)"
    @AndroidFindBy (uiAutomator = "className(\"android.widget.ImageView\").instance(27)")
    public WebElement kategoriler;
    @AndroidFindBy (uiAutomator = "className(\"android.widget.TextView\").instance(5)")
    public WebElement kategorilerBaslik;
    @AndroidFindBy (uiAutomator = "className(\"android.widget.ImageView\").instance(10)")
    public WebElement sporGiyim;
    @AndroidFindBy (uiAutomator = "className(\"android.widget.TextView\").instance(0)")
    public WebElement sporGiyimBaslik;

    public HepsiBuradaScreen() throws MalformedURLException {
    }
}
