package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagePersonalInformation {

    private static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    @Before
    public void Setup() throws Exception {
        Setup setup = new Setup();
        driver = setup.setUpTest();
        wait = setup.setUpDriverWait(driver);
    }

    @Test
    public void EditNameAndLastNameWithValidData() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/info_layout")).click();
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/account_name_layout")).click();
        Thread.sleep(1000);
        new Utils().screenshot(driver);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/firstName_txtLayout")));
        MobileElement firstName = driver.findElement(By.id("com.swaypay.b2c.development:id/firstName_editTxt"));
        MobileElement lastName = driver.findElement(By.id("com.swaypay.b2c.development:id/lastName_editTxt"));
        firstName.clear();
        firstName.sendKeys("TestEdit");
        lastName.clear();
        lastName.sendKeys("LastNameEdited");
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/names_done_button")).click();
        new Utils().screenshot(driver);
        Assert.assertEquals(true, wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.FrameLayout"))).isDisplayed());
    }

    @Test
    public void EditNameAndLastNameWithInValidData() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/info_layout")).click();
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/account_name_layout")).click();
        Thread.sleep(1000);
        new Utils().screenshot(driver);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/firstName_txtLayout")));
        MobileElement firstName = driver.findElement(By.id("com.swaypay.b2c.development:id/firstName_editTxt"));
        MobileElement lastName = driver.findElement(By.id("com.swaypay.b2c.development:id/lastName_editTxt"));
        firstName.clear();
        firstName.sendKeys("Th#@!$!@");
        lastName.clear();
        lastName.sendKeys("@!$!@$~%^");
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/names_done_button")).click();
        new Utils().screenshot(driver);
        Assert.assertEquals(false, !wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.FrameLayout"))).isDisplayed());
    }

    @Test
    public void UpdateEmailWithValidData() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/info_layout")).click();
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/account_email_layout")).click();
        Thread.sleep(1000);
        new Utils().screenshot(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/email_txtLayout")));

        MobileElement emailLayout = driver.findElement(By.id("com.swaypay.b2c.development:id/email_txtLayout"));
        emailLayout.clear();
        emailLayout.sendKeys("test@email.com");

        driver.findElement(By.id("com.swaypay.b2c.development:id/email_done_button")).click();
        new Utils().screenshot(driver);
        Assert.assertEquals(true, wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.FrameLayout"))).isDisplayed());
    }

    @Test
    public void UpdateEmailWithInValidData() throws Exception {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/progressBar1")));
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/info_layout")).click();
        new Utils().screenshot(driver);
        driver.findElement(By.id("com.swaypay.b2c.development:id/account_email_layout")).click();
        Thread.sleep(1000);
        new Utils().screenshot(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.swaypay.b2c.development:id/email_txtLayout")));

        MobileElement emailLayout = driver.findElement(By.id("com.swaypay.b2c.development:id/email_txtLayout"));
        emailLayout.clear();
        emailLayout.sendKeys("test@");
        new Utils().screenshot(driver);
        Assert.assertEquals(false, wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.FrameLayout"))).isDisplayed());    }
}