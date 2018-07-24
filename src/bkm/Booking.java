package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Booking {

    private static AndroidDriver<MobileElement> driver;
    private static AndroidDriver<MobileElement> browserDriver;
    public static WebDriverWait wait;
    public static WebDriverWait webDriverWait;
    Setup setup;

    @Before
    public void Setup() throws Exception {
        setup = new Setup();
        driver = setup.setUpTest();
        wait = setup.setUpDriverWait(driver);
        browserDriver = setup.setUpBrowserTest();
        webDriverWait = setup.setUpDriverWait(browserDriver);
    }

    @Test
    public void CompleteBookingWithGDPRFromMobileWeb() throws Exception {
        browserDriver.get("https://dev-simulator.swaypay.net/hotel");
        WebDriverWait wait = new WebDriverWait(browserDriver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("swp-toggle")));
        WebElement webElement = browserDriver.findElement(By.className("swp-toggle"));
        if (!webElement.isSelected()) {
            webElement.click();
        }
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/a[2]")));
        WebElement swaypayButton = browserDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/a[2]"));
        swaypayButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("swpmdl__main__form__tel")));
        browserDriver.findElement(By.className("swpmdl__main__form__tel")).sendKeys("5551235102");
        browserDriver.hideKeyboard();
        browserDriver.setLocation(new Location(49, 123, 10));
        browserDriver.findElement(By.className("swpmdl__main__form__submit")).click();
        browserDriver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".swpmdl__verify-number__inputs>input")));
        List<MobileElement> mobileElements = browserDriver.findElements(By.cssSelector(".swpmdl__verify-number__inputs>input"));
        String[] activationCode = {"5", "1", "0", "2"};
        for (int i = 0; i < mobileElements.size(); i++) {
            Thread.sleep(500);
            mobileElements.get(i).sendKeys(activationCode[i]);
        }
        Thread.sleep(2000);
        browserDriver.navigate().refresh();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div/a[2]")));
        browserDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/a[2]")).click();
    }
}