package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CompleteBooking {

    private static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @Before
    public void Setup() throws Exception {
        Setup setup = new Setup();
        driver = setup.setUpTest();
        wait = setup.setUpDriverWait(driver);
        if (driver.findElements(By.id("com.swaypay.b2c.development:id/getStarted_btn")).size() != 0) {
            UserLogin userLogin = new UserLogin();
            userLogin.Setup();
            userLogin.OnboardUser();
            driver = setup.setUpTest();
            wait = setup.setUpDriverWait(driver);
        }
    }

    @Test
    public void completeBookingWithGDPRWithinApp() throws Exception {
        new Utils().screenshot(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/createPurchaseButton")));
        driver.findElement(By.id("com.swaypay.b2c.development:id/createPurchaseButton")).click();
        Thread.sleep(4000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/hotel_back_button")));
        new Utils().screenshot(driver);
        if (driver.findElements(By.id("com.swaypay.b2c.development:id/store_cards_layout")).size() > 0
                && driver.findElements(By.id("com.swaypay.b2c.development:id/custom_card")).size() > 0) {
            driver.findElements(By.id("com.swaypay.b2c.development:id/custom_card")).get(0).click();
        }
        new Utils().screenshot(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/complete_button")));
        if (driver.findElements(By.className("android.widget.RelativeLayout")).size() > 0) {
            List<MobileElement> policies = driver.findElements(By.className("android.widget.RelativeLayout"));
            for (MobileElement policy : policies) {
                policy.findElement(By.id("com.swaypay.b2c.development:id/policy_switch")).click();
            }
        }
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/complete_button")).click();
        new Utils().screenshot(driver);
    }
}
