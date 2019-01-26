package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static
    {
        MY_LISTS_LINK = "xpath:/html/body/div[1]/nav/div/ul[2]/li[2]/a";//"xpath://*[@id='mw-mf-page-left']/div/ul[2]/li[3]/a";//"xpath://*[@id='mw-content-text']/div[1]/ul/li[1]/a";//"css:a[data-event-name='watchlist']";
        OPEN_NAVIGATION = "xpath://*[@id='mw-mf-main-menu-button']";//"xpath://*[@id='mw-mf-main-menu-button']/text()";//"xpath://*[@id='mw-content-text']/div/ul/li[1]/a";//"css:#mw-mf-main-menu-button";
    }
    public MWNavigationUI(RemoteWebDriver driver)
    {
        super(driver);

    }

}
