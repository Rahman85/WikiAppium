package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;


public class GetStartedTest extends CoreTestCase
{

    @Test
    public void testPassThroughWelcome ()
    {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW())) {
            return;
        }

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForElementMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWayToExplore();
        WelcomePage.clickNextButton();

        WelcomePage.waitForSearchInNearly300Languages();
        WelcomePage.clickNextButton();

        WelcomePage.waitForHelpMakeAppBetter();
        WelcomePage.clickGetStartedButton();
    }
}
