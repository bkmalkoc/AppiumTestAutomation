package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateUser {
    private static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @Before
    public void Setup() throws Exception {
        Setup setup = new Setup();
        driver = setup.setUpTest();
        wait = setup.setUpDriverWait(driver);
    }

    @Test
    public void NavigateUserThruSettingsAndFeedbackScreen() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_settings")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/arrowImgButton")).click();
        }
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/help_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
    }
}