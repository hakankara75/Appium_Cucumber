package utilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import static utilities.Driver.driver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import screens.androidScreen.ApiDemosScreen;


import java.util.Collections;


public class ReusableMethods {
  static protected ApiDemosScreen api;

  static {
    try {
      api = new ApiDemosScreen();
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public static boolean isElementPresent(String text) {
    boolean elementFound = false;
    List<WebElement> mobileElementList = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    for (WebElement el : mobileElementList) {
      if (el.getText().equals(text)) {
        waitToBeVisible(el, Duration.ofSeconds(10));
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
    waitToBeClickable(element, Duration.ofSeconds(10));
    element.click();
  }

  public static void enterText(WebElement element, String text) {
    waitToBeClickable(element, Duration.ofSeconds(10));
    element.sendKeys(text);
  }

  public static void enterText(WebElement element, String text, boolean needClear) {
    waitToBeClickable(element, Duration.ofSeconds(10));
    if (needClear) {
      element.clear();
    }
    element.sendKeys(text);
  }

  public static boolean isElementPresent(WebElement mobileElement) {
    boolean elementFound = false;
    waitToBeVisible(mobileElement, Duration.ofSeconds(10));
    if (mobileElement.isDisplayed()) {
      elementFound = true;
    }
    return elementFound;
  }

  public static void waitToBeVisible(WebElement element, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitToBeClickable(WebElement element, Duration timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void dragAndDrop(AppiumDriver driver, WebElement elemen1, WebElement element2) {

    Point sourceCenter = getCenterOfElement(elemen1.getLocation(), elemen1.getSize());
    Point targetCenter = getCenterOfElement(element2.getLocation(), element2.getSize());

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    Sequence sequence = new Sequence(finger, 1).
            addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter)).
            addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
            addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), targetCenter)).
            addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));

  }


  public static void tap(AppiumDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(200)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  public static void doubleTap(AppiumDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);

    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(100)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())).addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(100)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));


  }

  public static void longTap(AppiumDriver driver, WebElement element) {
    Point location = element.getLocation();
    Dimension size = element.getSize();

    Point centerOfElement = getCenterOfElement(location, size);
    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1).addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement)).
            addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).
            addAction(new Pause(finger1, Duration.ofSeconds(4))).
            addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));


  }

  public static void scroll(AppiumDriver driver,int scroll) throws InterruptedException {
    Dimension size = driver.manage().window().getSize();
    int startX = size.getWidth() / 2;
    int startY = size.getHeight() / 2;
    int endX = startX;
    int endY = (int) (size.getHeight() * 0.25);
    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");


    for (int i = 0; i <scroll ; i++) {

      Sequence sequence1 = new Sequence(finger1, 1)
              .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
              .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
              .addAction(new Pause(finger1, Duration.ofMillis(200)))
              .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
              .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

      driver.perform(Collections.singletonList(sequence1));}
    Thread.sleep(300);
  }

  /**
   * Element gorunur olmadigi surece ve sayfa sonuna gelinmedigi surece scroll down yapma metodu
   * @param element yerine android element locati verilmeli
   */
  public static void scrollForMobile(WebElement element){
    String previousPageSource="";
    while(isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)){
      previousPageSource=driver.getPageSource();
      performScroll();

    }
  }

  /**
   * elementi listin icine alıp, listin boyutunu olcer. list bos ise true dondurecek.scrollForMobile() ile kullanilir
   * @param element element locate yazilmali
   * @return true yada false doner
   */
  private static boolean isElementNotEnabled(WebElement element){
    List<WebElement> elements=driver.findElements((By) element);
    boolean enabled;
    if (elements.size() <1) enabled = true;
    else enabled = false;
    return enabled;
  }

  /**
   * bir onceki sayfa pageSource ile simdiki aynı mı diye kontrol eder
   * @param previousPageSource
   * @return
   */
  private static boolean isNotEndOfPage(String previousPageSource){
    return ! previousPageSource.equals(driver.getPageSource());
  }
  public static void performScroll(){
    Dimension size= driver.manage().window().getSize();
    int startX= size.getWidth()/2;
    int endX= size.getWidth()/2;
    int startY= size.getHeight()/2;
    int endY= (int)(size.getWidth()*0.25);
    performScrollUsingSequence(startX, startY, endX, endY);
  }
  private static void performScrollUsingSequence(int startX, int startY, int endX, int endY)
  {
    PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "first-finger");
    Sequence sequence=new Sequence(finger,0)
            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    ((AppiumDriver)(driver)).perform(Collections.singletonList(sequence));
  }
  private static Point getCenterOfElement(Point location, Dimension size) {
    return new Point(location.getX() + size.getWidth() / 2,
            location.getY() + size.getHeight() / 2);
  }

  public static  void tabOnElementWithText(String text) throws InterruptedException {

    List<WebElement> elements = driver.findElements(AppiumBy.className("android.widget.TextView"));

    for (WebElement element : elements){
      System.out.println("element.getText() = " + element.getText());
      if(element.getText().contains(text)){
        System.out.println("element.getText()111 = " + element.getText());

        element.click();
        break;
      }else ReusableMethods.scroll(driver,1);
      break;
    }
  }

  public static void scrollTo(String textFromOutSide){
    AppiumBy.ByAndroidUIAutomator permissionElement = new AppiumBy.ByAndroidUIAutomator("new UiScrollable"+
            "(new UiSelector().scrollable(true).instance(0)."+
            "scrollIntoView(new UiSelector()"+".textMatches(\""+textFromOutSide+"\").instance(0)");
    driver.findElement(permissionElement);
  }

  /**
   * bu metot UiSelector cinsinden locate dondurur
   * @param text locate alinacak elementin text attribute icinde yazan metindir
   * @return
   */
  public static By locateElementByText(String text){
    return AppiumBy.androidUIAutomator("new UiSelector().text(\""+text+"\")");
  }
}