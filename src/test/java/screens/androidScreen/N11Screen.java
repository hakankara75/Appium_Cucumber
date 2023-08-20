package screens.androidScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N11Screen extends ApiDemosScreen{
   @FindBy(id = "com.dmall.mfandroid.id/tvHomeSearchBar")
   public WebElement searchBox;
   @FindBy(id = "com.dmall.mfandroid.id/etSearch")
   public WebElement searchBar;
   @FindBy(xpath = "//android.widget.TextView[@text='kulaklık']")
   public WebElement kulaklikText;
   @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/ivAddToBasket'])[1]")
   public WebElement firstProduct;
   @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.dmall.mfandroid:id/navigation_category']")
   public WebElement sepetim;
   @FindBy(xpath = "//android.widget.TextView[@text='Beyaz']")
   public WebElement beyaz;
   @FindBy(xpath = "//android.widget.TextView[@text='Sepete Ekle']")
   public WebElement sepeteEkle;
   @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.dmall.mfandroid:id/navigation_bar_item_icon_view'])[3]")
   public WebElement secondSepetim;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ödemeye Geç\")")
   public WebElement odemeyeGecText;
}
