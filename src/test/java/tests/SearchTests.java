package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactories;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchTests extends CoreTestCase {

    @Test
    public void testSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);

        SearchPageObject.InitSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitforSearchResult("bject-oriented programming language");
    }


    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);

        SearchPageObject.InitSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        { if (Platform.getInstance().isAndroid())
            return;
        SearchPageObject.waitForCancelButtonToDisappear();
        }
}




    @Test
    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);
        SearchPageObject.InitSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactories.get(driver);
        SearchPageObject.InitSearchInput();
        String search_line = "ertffgjtuyrujjuytjguy";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultlabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }


}
