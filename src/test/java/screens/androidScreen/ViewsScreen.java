package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ViewsScreen {
    public ViewsScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    public WebElement viewsTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
    public WebElement dragDropButton;

}
