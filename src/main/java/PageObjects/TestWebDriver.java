package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebDriver {
	WebDriverManager wdm = WebDriverManager.chromedriver().watchAndDisplay();
	

	@BeforeTest
	void setupClass() {
	
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/rajakd//OneDrive - AMDOCS//Desktop//JAVA/chromedriver-win64/chromedriver.exe");
	}

	@Test
	void test() {
		WebDriver driver = new ChromeDriver();
		// Exercise
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		String title = driver.getTitle();

	}

}
