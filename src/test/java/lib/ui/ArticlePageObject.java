package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObjects {

    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    ADD_TO_MY_LIST_BUTTON,
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    SKIP_SYNCHRONIZATION;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 25);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()) {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Can not find the end of the article",
                50);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Can not find the end of the article",
                    50);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                    "Can not find the end of the article",
                    50);
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Can not find button to open article option",
                15);

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_BUTTON,
                "Can not find option 'Add to reading list'",
                15);

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Can not find tip overlay 'GOT IT'",
                15);

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Can not find input to set name of article folder",
                15);

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Can not put text into article folder input",
                15);

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Can not press 'OK' button",
                15);
    }

    public void addArticlesToMySaved()
    {
        if(Platform.getInstance().isMW())
    {
        this.removeArticleFromSavedIfItAdded();

    }
        this.waitForElementAndClick(ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                15);
    }

    public void removeArticleFromSavedIfItAdded()
    {
        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
           this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                   "Cannot click button to remove an article from saved",
                   15);
           this.waitForElementPresent(ADD_TO_MY_LIST_BUTTON,
                   "Cannot find button to add an article to saved list after removing it from this list before",
                   15);
        }
    }

    public void closeArticle()
    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Can not close article, cannot find x link",
                    15);
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Can not close article, cannot find x link",
                    15);
        } else if (Platform.getInstance().isAndroid())
        {            this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Can not close article, cannot find x link",
                15);
        } else {

            System.out.println("Method closeArticle() do nothing for Platform " + Platform.getInstance().getPlatformVar());
        }

    }
    public void skipSynchonization()




    {
        if (Platform.getInstance().isIOS())
        {
            this.waitForElementAndClick(SKIP_SYNCHRONIZATION,
                    "Cannot skip synchronization",
                    20);
        } else {
            return;
        }
    }
}
