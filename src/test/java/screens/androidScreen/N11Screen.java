package screens.androidScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class N11Screen extends ApiDemosScreen{
   @FindBy(id = "com.dmall.mfandroid.id/tvHomeSearchBar")
   public WebElement searchBox;
   @FindBy(id = "com.dmall.mfandroid.id/etSearch")
   public WebElement searchBar;

}
