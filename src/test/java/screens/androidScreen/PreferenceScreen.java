package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class PreferenceScreen {

    public PreferenceScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Preference']")
    public WebElement preferenceScreenTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement preferenceDependencies;

    @FindBy(xpath = "//android.widget.TextView[@text='9. Switch']")
    public WebElement preferenceSwitchButton;

}
