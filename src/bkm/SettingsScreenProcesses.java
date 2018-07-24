package bkm;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingsScreenProcesses {
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
    public void AddACreditCard() throws Exception {
        new Utils().screenshot(driver);
        if (wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/app_bar_order")))
                .isDisplayed()) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/settings_img_imagebutton")).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);

        List<MobileElement> addNewCardButton = driver.findElements(By.id("com.swaypay.b2c.development:id/addNewCreditCard"));
        List<MobileElement> addAnotherCardButton = driver.findElements(By.id("com.swaypay.b2c.development:id/addCreditCard"));

        if (addNewCardButton.size() != 0) {
            addNewCardButton.get(0).click();
        } else if (addAnotherCardButton.size() != 0) {
            addAnotherCardButton.get(0).click();
        }
        if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size() != 0) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
            driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));
        driver.findElements(By.className("android.widget.Button")).get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/card_number_enter")));
        driver.findElement(By.id("com.swaypay.b2c.development:id/card_number_enter")).sendKeys("4242424242424242");
        if (driver.findElement(By.id("com.swaypay.b2c.development:id/card_name_enter")).getText() == null) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/card_name_enter")).sendKeys("JOHN DOE");
        }
        driver.findElement(By.id("com.swaypay.b2c.development:id/card_expDate_enter")).sendKeys("1122");
        driver.findElement(By.id("com.swaypay.b2c.development:id/card_cvv_enter")).sendKeys("555");

        driver.hideKeyboard();
        new Utils().screenshot(driver);
        if (driver.findElements(By.id("com.swaypay.b2c.development:id/billing_address_picker")).size() != 0) {
            driver.findElement(By.id("com.swaypay.b2c.development:id/billing_address_picker")).click();
            driver.findElement(By.id("com.swaypay.b2c.development:id/search_et")).sendKeys("123");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/list_search")));
            driver.findElements(By.id("com.swaypay.b2c.development:id/list_search")).get(0).click();
        }

        new Utils().screenshot(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/save_bar_button")));
        driver.findElement(By.id("com.swaypay.b2c.development:id/save_bar_button")).click();

        new Utils().screenshot(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/terms_agree_button")));
        driver.findElement(By.id("com.swaypay.b2c.development:id/terms_agree_button")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.swaypay.b2c.development:id/user_info_progressbar")));
        new Utils().screenshot(driver);

        List<MobileElement> cardLayout = driver.findElements(By.id("com.swaypay.b2c.development:id/stored_cards_listView"));
        Assert.assertEquals(1, cardLayout.size());
    }
}