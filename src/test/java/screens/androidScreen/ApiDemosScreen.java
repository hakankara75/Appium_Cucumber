package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ApiDemosScreen {

    public ApiDemosScreen () {
        try {
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
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
    @FindBy(xpath = "//android.widget.TextView[@text='9. Switch']")
    public WebElement switchButton;
    @FindBy(xpath = "//android.widget.CheckBox[@resource-id='android:id/checkbox']")
    public WebElement checkBox;
    @FindBy(xpath = "//android.widget.Switch[@text='ON']")
    public WebElement switchPreference;
    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    public WebElement viewLink;
    @FindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    public WebElement dragAndDrop;
    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_1")
    public WebElement dragAndDropOne;
    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_2")
    public WebElement dragAndDropTwo;
}
