package bkm;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Setup {
    private static AndroidDriver<MobileElement> driver;

    @Before
    public AndroidDriver<MobileElement> setUpTest() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        // Samsung
//         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "heroqltetmo");
//         capabilities.setCapability(MobileCapabilityType.UDID, "aca2ebb5");

        // Pixel 2
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "walleye");
        capabilities.setCapability(MobileCapabilityType.UDID, "HT7B31A05667");

        capabilities.setCapability(MobileCapabilityType.APP, "C:/app-development-release.apk");
        capabilities.setCapability("appPackage", "com.swaypay.b2c.development");
        capabilities.setCapability("appActivity", "com.swaypay.b2c.activity.OnBoardingActivity");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("gpsEnabled", true);
        capabilities.setCapability("javascriptEnabled", true);
        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new AndroidDriver<>(new URL("http://192.168.0.4:4723/wd/hub"), capabilities);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }


    @Before
    public AndroidDriver<MobileElement> setUpBrowserTest() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        // Samsung
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "heroqltetmo");
//        capabilities.setCapability(MobileCapabilityType.UDID, "aca2ebb5");

        // Pixel 2
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "walleye");
        capabilities.setCapability(MobileCapabilityType.UDID, "HT7B31A05667");
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("gpsEnabled", true);
        capabilities.setCapability("javascriptEnabled", true);
        capabilities.setCapability("setWebContentsDebuggingEnabled", true);

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new AndroidDriver<MobileElement>(new URL("http://192.168.0.4:4723/wd/hub"), capabilities);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriverWait setUpDriverWait(AppiumDriver<MobileElement> driver) {
        return new WebDriverWait(driver, 15);
    }

    public WebDriverWait setUpWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, 15);
    }
}
