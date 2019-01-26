package lib.ui;


import org.openqa.selenium.remote.RemoteWebDriver;
import tests.GetStartedTest;

public class WelcomePageObject extends MainPageObjects
{
    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_SEARCH_IN_NEARLY_300_LANGUAGES = "id:Search in nearly 300 languages",
    STEP_HELP_MAKE_APP_BETTER = "id:Help make the app better",
    NEXT_LINK = "id:Next",
    GET_STARTED_BUTTON = "id:Get started",
    SKIP_BUTTON = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);

    }

    public void waitForElementMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' Link",
                10);
    }

    public void waitForNewWayToExplore()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'New ways to explore' Link",
                10);
    }

    public void waitForSearchInNearly300Languages()
    {
        this.waitForElementPresent(STEP_SEARCH_IN_NEARLY_300_LANGUAGES,
                "Cannot find 'Search in nearly 300 languages' Link",
                10);
    }

    public void waitForHelpMakeAppBetter()
    {
        this.waitForElementPresent(STEP_HELP_MAKE_APP_BETTER,
                "Cannot find 'Help make the app better' Link",
                10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_LINK,
                "Cannot find and click 'Next' Link",
                10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON,
                "Cannot find and click 'Get started' Link",
                10);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP_BUTTON,
                "Cannot find 'Skip' button",
                15);
    }

}
