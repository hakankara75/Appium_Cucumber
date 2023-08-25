package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public class DateWidgetsScreen {
    public DateWidgetsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(accessibility = "9")
    public WebElement num9;

    @AndroidFindBy(accessibility = "15")
    public WebElement num15;

    @AndroidFindBy(accessibility = "45")
    public WebElement num45;
}
