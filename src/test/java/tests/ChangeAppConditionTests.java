package tests;

import javafx.print.PageLayout;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactories;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationSearchResult() {

        if (Platform.getInstance().isMW())
        {
            return;
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);
        SearchPageObject.InitSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String title_before_rotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandccape();
        String title_after_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title has been changed after rotation",
                title_before_rotation,
                title_after_rotation);

        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title has been changed after rotation",
                title_before_rotation,
                title_after_second_rotation);
    }

    @Test
    public void testCheckSearchArticleInBackground() {
        if(Platform.getInstance().isMW()){
            return;
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);

        SearchPageObject.InitSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitforSearchResult("Object-oriented programming language");
        this.backgroundApp(5);
        SearchPageObject.waitforSearchResult("Object-oriented programming language");
    }

}
