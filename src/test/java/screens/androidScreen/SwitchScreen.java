package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class SwitchScreen {

    public SwitchScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)),this);
    }

    @FindBy(id = "android:id/checkbox")
    public WebElement checkBox;

    @FindBy(xpath = "(//android.widget.Switch)[1]")
    public WebElement firstSwitch;
    @FindBy(xpath = "(//android.widget.Switch)[2]")
    public WebElement secondSwitch;

}
