package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath://*[@id='section_0']";//"xpath://*[@id='mw-mf-page-center']/header"; //"css:#content h1";
        FOOTER_ELEMENT =  "xpath://*[@id='mw-mf-display-toggle']";//"xpath://*[@id='mw-mf-page-center']/footer"; //"css:footer";
        ADD_TO_MY_LIST_BUTTON = "xpath:/html/body/div[1]/div/main/div[1]/ul/li[2]/a";//xpath://*[@id='ca-watch']/a";//"css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath:/html/body/div[1]/div/main/div[2]/ul/li/div";//"css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
    }
    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
