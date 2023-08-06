package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class ApiDemosScreen {

    public ApiDemosScreen () {
        try {
            PageFactory.initElements(Driver.getAppiumDriver(), this);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FindBy(xpath = "//android.widget.TextView[contains(@text='API')]")
    public WebElement apiTitle;
    @FindBy(xpath = "//android.widget.TextView[contains(@text='Preference')]")
    public WebElement preference;
    @FindBy(xpath = "//android.widget.TextView[contains(@text='1. Preferences from XML')]")
    public WebElement preferenceArea;
    @FindBy(xpath = "//android.widget.TextView[contains(@text='3. Preference dependencies')]")
    public WebElement preferenceDependencies;
    @FindBy(id = "android:id/widget_frame")
    public WebElement wifiCheckBox;
    @FindBy(xpath = "//android.widget.TextView[contains(@text='WiFi settings')]")
    public WebElement wifiSettings;
    @FindBy(id = "android:id/alertTitle")
    public WebElement wifiSettingsPopup;
    @FindBy(id = "android:id/edit")
    public WebElement wifiSettingsTextBox;
    @FindBy(id = "android:id/button1")
    public WebElement okButton;
}
