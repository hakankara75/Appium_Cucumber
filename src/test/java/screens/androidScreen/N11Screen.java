package screens.androidScreen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

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
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Huawei FreeBuds 5i Bluetooth Kulak içi Kulaklık\")")
   public WebElement firstSelectProduct;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Kategoriler\")")
   public WebElement kategoriler;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Otomotiv & Motosiklet\")")
   public WebElement otomotiv;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yedek Parça\")")
   public WebElement yedekParca;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Egzoz\")")
   public WebElement egzoz;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Filtrele\")")
   public WebElement filtrele;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Teslimat Adresi Seç\")")
   public WebElement teslimatAdresi;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Şehir Seç\")")
   public WebElement sehirSec;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"İlçe Seç\")")
   public WebElement ilceSec;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sonuçları Göster\")")
   public WebElement sonuclariGoster;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Onayla\")")
   public WebElement onayla;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"İstanbul\")")
   public WebElement istanbul;
   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beşiktaş\")")
   public WebElement besiktas;
   public N11Screen() throws MalformedURLException {
   }
}
