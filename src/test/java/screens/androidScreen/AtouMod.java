package screens.androidScreen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtouMod extends ApiDemosScreen{

    @FindBy(xpath = "//android.widget.TextView[contains(@text='API')]")
    public WebElement apiTitle;
}
