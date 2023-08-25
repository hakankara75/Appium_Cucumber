package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class PreferenceDependenciesScreen {

   public PreferenceDependenciesScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)),this);
    }

    @FindBy(id="android:id/checkbox")
    public WebElement checkBox;

    @FindBy(xpath = "//android.widget.TextView[@text='WiFi settings']")
    public WebElement wifiSettings;

    @FindBy(id = "android:id/button2")
    public WebElement cancelButton;

    @FindBy(id = "android:id/button1")
    public WebElement okButton;

    @FindBy(id = "android:id/edit")
    public WebElement textBox;
}
