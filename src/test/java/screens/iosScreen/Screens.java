package screens.iosScreen;

import screens.androidScreen.ApiDemosScreen;

import java.net.MalformedURLException;

public class Screens {

    public Screens() {

    }

    private ApiDemosScreen apiDemosScreen;
    public ApiDemosScreen apiDemosScreen() throws MalformedURLException {
    if (apiDemosScreen == null) {
        apiDemosScreen= new ApiDemosScreen();
    }
    return apiDemosScreen;
    }

}