package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObjects;

public class IOSMyListPageObject extends MyListsPageObjects
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='(TITLE)')]";
    }
    public IOSMyListPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
