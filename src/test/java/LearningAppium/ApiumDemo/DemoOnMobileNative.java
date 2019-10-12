package LearningAppium.ApiumDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * 
 */
public class DemoOnMobileNative {

	private static AndroidDriver driver;
	@Test
	public void testNative() throws MalformedURLException, InterruptedException {
		// Create object of DesiredCapabilities class

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Optional

		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");

		// Specify the device name (any name)

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "My Xiomi Note 5 Pro");

		// Platform version

		capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");

		// platform name

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		// specify the application package that we copied from appium

		capabilities.setCapability("appPackage", "io.selendroid.testapp");

		// specify the application activity that we copied from appium

		capabilities.setCapability("appActivity", ".HomeScreenActivity");

		// Start android driver I used 4727 port by default it will be 4723

		driver = new AndroidDriver(new URL("http://127.0.0.1:4728/wd/hub"), capabilities);

		// Specify the implicit wait of 5 second

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Enter the text in textbox

		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field"))
				.sendKeys("This is test message");

		// click on registration button

		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();

		// close the application
		driver.quit();

	}
}
