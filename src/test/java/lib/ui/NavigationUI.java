package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObjects {

    protected static String

    MY_LISTS_LINK,
    OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
       if (Platform.getInstance().isMW())
       {
           this.waitForElementAndClick(OPEN_NAVIGATION,
                   "Cannot open and click opn navigation button",
                   20);
       } else {
           System.out.println("Method openNavigation() do nothing for Platform " + Platform.getInstance().getPlatformVar());
       }
    }

    public void clickMyList() {
        if (Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK,
                    "Can not find Navigation button to My lists",
                    20);
        }


        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Can not find Navigation button to My lists",
                15);
    }
}
