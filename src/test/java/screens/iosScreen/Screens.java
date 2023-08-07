package screens.iosScreen;

import screens.androidScreen.ApiDemosScreen;

public class Screens {

    public Screens() {

    }

    private ApiDemosScreen apiDemosScreen;
    public ApiDemosScreen apiDemosScreen() {
    if (apiDemosScreen == null) {
        apiDemosScreen= new ApiDemosScreen();
    }
    return apiDemosScreen;
    }

}