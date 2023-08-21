package screens.androidScreen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class AtouModScreen extends ApiDemosScreen {

    @FindBy(xpath = "//android.widget.TextView[@text='Vos titres de transport\n" +
            "où et quand vous voulez !']")
    public WebElement textTitresDeTransport;


    @FindBy(xpath = "//android.widget.TextView[@text='Plus tard']")
    public WebElement btnPlusTard;


    @FindBy(xpath = "//android.widget.Image[@text='checked CGU/CGV']")
    public WebElement btnChecked;

    @FindBy(xpath = "//android.widget.TextView[@text='OK']")
    public WebElement btnOK;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Vous pouvez effectuer des achats jusqu'à 50€, mais pour enregistrer une carte il vous faudra créer un compte.\"]")
    public WebElement getTextCGU;

    @FindBy(xpath = "//android.widget.TextView[@text='Pourquoi activer la géolocalisation? ']")
    public WebElement textGeolocalisation;

    @FindBy(xpath = "//android.widget.TextView[@text=\"OK, j'ai compris !\"]")
    public WebElement btnOKJ;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement btnAutoriser;

    @FindBy(xpath = "(//android.widget.TextView)[1]")
    public WebElement btnReseau;

    @FindBy(className = "android.widget.EditText")
    public WebElement searchReseau;

    public AtouModScreen() throws MalformedURLException {
    }
}
