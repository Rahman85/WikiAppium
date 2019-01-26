package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactories;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {


    private static final String name_of_folder = "Learning Programing";
    private static final String login = "rahman_hazar", password = "wikiproject";
    @Test
    public void testSaveFirstArticleToMyList() {

        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);

        SearchPageObject.InitSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMW()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();

            assertEquals("We are not on the same page after login.",
                    article_title,
                    ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyList();

        MyListsPageObjects MyListsPageObjects = MyListPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()) {
           MyListsPageObjects.waitForFolder(name_of_folder);
           MyListsPageObjects.openFolderByName(name_of_folder);
        }
        MyListsPageObjects.swipeByArticleToDelete(article_title);
    }
}
