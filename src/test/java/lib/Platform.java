package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Dimension;


public class Platform {

    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String Appium_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance()
    {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception
    {
        URL URL = new URL(Appium_URL);
        if(this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isMW()){
            return new ChromeDriver(this.getMwChromeoptions());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMW()
    {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/rahman/WikiAppium/apks/org.wikipedia.apk");
        return capabilities;
    }
    private DesiredCapabilities getIOSDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "11.3");
        capabilities.setCapability("app", "/Users/rahman/Desktop/Wikipedia 2.app");
        return capabilities;
    }

    private ChromeOptions getMwChromeoptions()
    {
        //Map<String, String> mobileEmulation = new HashMap<String, String>();
        //mobileEmulation.put("deviceName", "Nexus 5");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        //WebDriver driver = new ChromeDriver(chromeOptions);
        //driver.get("https://en.m.wikipedia.org");


        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.addArguments("window -size = 340, 640");

        //WebDriver driver = new ChromeDriver();
        //Dimension d = new Dimension(340,640);
        //driver.manage().window().setSize(d);


        return options;


        //DesiredCapabilities cap = DesiredCapabilities.chrome();
        //cap.setCapability(ChromeOptions.CAPABILITY, Capabilities);


        //Dimension d = new Dimension(340, 640);
        //driver.manage().window().setPosition(new Point(0, 0));



        //
        //driver.manage().window().setSize(new WebDriverDi(360,640) );
        //;



    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        {
            return my_platform.equals(platform);
        }
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}

