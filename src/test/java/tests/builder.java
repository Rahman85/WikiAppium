package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class builder {

    ChromeDriver wd;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/rahman/Desktop/chromedriver");
        WebDriver wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void builder() {
        wd.get("https://en.m.wikipedia.org/wiki/Main_Page");
        wd.findElement(By.id("searchIcon")).click();
        wd.findElement(By.xpath("//div[@class='overlay-title']/form/input")).click();
        wd.findElement(By.xpath("//div[@class='overlay-title']/form/input")).clear();
        wd.findElement(By.xpath("//div[@class='overlay-title']/form/input")).sendKeys("Java");
        wd.findElement(By.linkText("Java (programming language)\n		    object-oriented programming language")).click();
        wd.findElement(By.linkText("Watch this page")).click();
        wd.findElement(By.cssSelector("a.mw-ui-button.mw-ui-progressive\n		\n		\n		 \n	")).click();
        wd.findElement(By.id("wpName1")).click();
        wd.findElement(By.id("wpName1")).clear();
        wd.findElement(By.id("wpName1")).sendKeys("Rahman hazar");
        wd.findElement(By.id("wpPassword1")).click();
        wd.findElement(By.id("wpPassword1")).clear();
        wd.findElement(By.id("wpPassword1")).sendKeys("wikiproject");
        wd.findElement(By.id("wpLoginAttempt")).click();
        wd.findElement(By.linkText("Watch this page")).click();
        wd.findElement(By.id("mw-mf-main-menu-button")).click();
        wd.findElement(By.linkText("Watchlist")).click();
        wd.findElement(By.xpath("//div[@id='mw-content-text']//div[.='Stop watching']")).click();
        wd.navigate().refresh();
    }

    @After
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
