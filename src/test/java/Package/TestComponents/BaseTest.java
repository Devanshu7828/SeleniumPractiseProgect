package Package.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public HomePage homePage;

	public WebDriver initializeDrive() throws IOException {
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Resources//DataFile.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {

			// WebDriver browser
//			System.setProperty("webdriver.chrome.driver",
//					"/Users/rajakd//OneDrive - AMDOCS//Desktop//JAVA/chromedriver-win64/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				chromeOptions.addArguments("headless");
			}

			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().setSize(new Dimension(1440, 900));

		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge browser code
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Edge browser code
		}
////
//		if (browserName.contains("chrome")) {
////			ChromeOptions chromeOptions = new ChromeOptions();
////			WebDriverManager.chromedriver().setup();
////			driver = new ChromeDriver(chromeOptions);
//
//			System.setProperty("webdriver.chrome.driver",
//					"/Users/rajakd//OneDrive - AMDOCS//Desktop//JAVA/chromedriver-win64/chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.manage().window().setSize(new Dimension(1440, 900));
//		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public HomePage launchApplication() throws IOException {
		driver = initializeDrive();
		homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	// this method read data from Json file
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

//Convert String to HashMap for this we use Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
}
