package screens.androidScreen;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DragAndDropScreen {
    public DragAndDropScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_1")
    public WebElement firstDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_2")
    public WebElement secondDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_3")
    public WebElement thirdDot;

    @FindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_hidden")
    public WebElement fourthDot;

}
