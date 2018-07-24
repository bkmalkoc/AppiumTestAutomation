package bkm;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public Utils() {
	}

	public void screenshot(AppiumDriver<MobileElement> driver) throws IOException {
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		// String filename = UUID.randomUUID().toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ssaa");
		String filename = dateFormat.format(new Date());
		File targetFile = new File("screenshot/" + filename + ".jpg");
		FileUtils.copyFile(srcFile, targetFile);
	}
}
