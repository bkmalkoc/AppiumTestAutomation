package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UserLogin {

    private static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @Before
    public void Setup() throws Exception {
        Setup setup = new Setup();
        driver = setup.setUpTest();
        wait = setup.setUpDriverWait(driver);
    }

    @Test
    public void OnboardUser() throws Exception {
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/getStarted_btn")).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        new Utils().screenshot(driver);
//        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if(driver.findElements(By.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).size() > 0) {
            driver.findElement(By.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']")).click();
        }
        new Utils().screenshot(driver);
//            if (wait.until(ExpectedConditions
//                    .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/phone_number_edit_txt")))
//                    .isDisplayed()) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/phone_number_edit_txt")));
//        driver.findElement(By.id("com.swaypay.b2c.development:id/phone_number_edit_txt")).sendKeys("5551235102");
//        }
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));

        driver.hideKeyboard();

        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        new Utils().screenshot(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/send_sms")));
        driver.findElement(By.id("com.swaypay.b2c.development:id/send_sms")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/verification_code_txt")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/code1Txt")).sendKeys("5102");
            new Utils().screenshot(driver);
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        }
        if (wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/f_name_layout")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/f_name_layout")).sendKeys("John");
            driver.findElement(By.id("com.swaypay.b2c.development:id/l_name_layout")).sendKeys("Doe");
            driver.findElement(By.id("com.swaypay.b2c.development:id/email_layout")).sendKeys("jdoe@swaypay.io");
        }
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/done_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/indicator")));
        new Utils().screenshot(driver);
        Assert.assertEquals("com.swaypay.b2c.activity.OrdersMainActivity", driver.currentActivity());
    }

//	@Test
//	public void NavigateThruSettingsAndFeedbackScreens() throws Exception {
//		
//	}

    @After
    public void End() {
        driver.quit();
    }
}