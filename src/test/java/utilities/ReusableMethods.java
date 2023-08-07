package utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;


public class ReusableMethods {
    static List<WebElement> mobileElementList;
    static WebDriverWait wait;
    public static void tapOnElementWithText(String text) throws MalformedURLException {
        mobileElementList = Driver.getAppiumDriver().findElements(By.xpath("android.widget.TextView"));
        for (WebElement page: mobileElementList) {
            if (page.getText().equals(text)){
                page.click();
            }else{
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    //ikinci alternatif bir method
    public static void clickOnElementWithText(String elementText) throws InterruptedException, MalformedURLException {
        Thread.sleep(4000);
       mobileElementList = Driver.getAppiumDriver().findElements(By.xpath("//android.widget.TextView[@text='"+elementText+"']"));
        if (mobileElementList.size()>0){
            mobileElementList.get(0).click();
        }else scrollWithUiScrollable(elementText);
    }


    public static boolean isElementPresent(String text) throws MalformedURLException {
        boolean elementFound = false;
        mobileElementList = Driver.getAppiumDriver().findElements(By.xpath("//android.widget.TextView[@text='" + text + "']"));
        for (WebElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tapOn(WebElement element) {
        try {
            waitToBeClickable(element, 10);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        element.click();
    }

    public static void enterText(WebElement element, String text) throws MalformedURLException {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    public static void enterText(WebElement element, String text, boolean needClear) {
        try {
            waitToBeClickable(element, 10);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public static boolean isElementPresent(WebElement mobileElement)  {
        boolean elementFound = false;
        try {
            waitToBeVisible(mobileElement, 10);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    public static void waitToBeVisible(WebElement element, int timeout) throws MalformedURLException {
        wait= new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(WebElement element, int timeout) throws MalformedURLException {
        wait = new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) throws MalformedURLException {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))"));
        tapOn(driver.findElement(By.xpath("//android.widget.TextView[@text='" + elementText + "']")));
    }

    public static void scrollDownToBeVisible(WebElement element) {

    }

    public static void scrollUpToBeVisible(WebElement element) {

    }

    public static void swipeFromElementToElement(WebElement el1, WebElement el2) {

    }

}