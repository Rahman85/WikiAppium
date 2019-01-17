package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObjects extends MainPageObjects {

    protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("(FOLDER_NAME)", name_of_folder);
    }

    private static String getSavedArticleByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("(TITLE)", article_title);
    }


    public MyListsPageObjects(AppiumDriver driver)
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
        this.swipeElementToLeft(article_xpath,
                "cannot find saved article",
                30);

        if (Platform.getInstance().isIOS()){
            this.clickElementTheRightUpperCorner(article_xpath, "Cannot find saved article");

        }

        this.waitForArticleToDisappearByTitle(article_title);
    }

}
