package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObjects extends MainPageObjects {

    protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL,
    REMOVE_FROM_SAVED_BUTTON;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("(FOLDER_NAME)", name_of_folder);
    }

    private static String getSavedArticleByTitle(String article_title)
    {
        System.out.println(ARTICLE_BY_TITLE_TPL);
        return ARTICLE_BY_TITLE_TPL.replace("(TITLE)", article_title);
    }

    public static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("(TITLE)", article_title);
    }


    public MyListsPageObjects(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Can not find folder by name " + name_of_folder,
                25);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title " + article_title, 25);

    }

    public void waitForFolder(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementPresent (folder_name_xpath, "Cannot find saved folder " + name_of_folder, 25);

    }


    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath,
                "Saved article still present with title " + article_title,
                30);

    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(article_xpath,
                "cannot find saved article",
                30);
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(remove_locator,
                    "Cannot click button to remove article from saved",
                    10);
        }

        if (Platform.getInstance().isIOS()){
            this.clickElementTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(article_title);
    }

}
