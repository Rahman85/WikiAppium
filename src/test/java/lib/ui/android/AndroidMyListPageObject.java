package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObjects;

public class AndroidMyListPageObject extends MyListsPageObjects
{
    static {
    FOLDER_BY_NAME_TPL = "xpath://*[@text ='(FOLDER_NAME)']";
    ARTICLE_BY_TITLE_TPL = "xpath://*[@text ='(TITLE)']";

    }

    public AndroidMyListPageObject(AppiumDriver driver)
    {
        super(driver);

    }
}
