package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsPageObjects;
import lib.ui.android.AndroidMyListPageObject;
import lib.ui.ios.IOSMyListPageObject;
import lib.ui.mobile_web.MWMyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory
{
    public static MyListsPageObjects get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListPageObject(driver);
        } else if(Platform.getInstance().isAndroid()) {
            return new IOSMyListPageObject(driver);
        }else {
            return new MWMyListPageObject(driver);
        }
    }
}
