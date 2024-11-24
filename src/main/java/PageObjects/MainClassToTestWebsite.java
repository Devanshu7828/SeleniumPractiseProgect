package PageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClassToTestWebsite {
	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().setSize(new Dimension(1440, 900));
		driver.get("https://automationexercise.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		// Click on Signup / Login button
		driver.findElement(By.cssSelector(".nav li:nth-child(4) a")).click();

		// Register User code
//		RegisterUser();

		driver.findElement(By.cssSelector(".login-form [name='email']")).sendKeys("Testinguser1@outlook.com");
		driver.findElement(By.cssSelector(".login-form [name='password']")).sendKeys("testPass");
		driver.findElement(By.cssSelector(".login-form button")).click();

		// Products
		driver.findElement(By.cssSelector("a[href*='/products']")).click();
		driver.findElement(By.id("search_product")).sendKeys("Blue Top");
		driver.findElement(By.id("submit_search")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".productinfo"));
		
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("p")).getText().
						equals("Blue Top"))
				.findFirst().orElse(null);
		
		System.out.println(prod.getText());
		new Actions(driver).moveToElement(prod).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart")));
		prod.findElement(By.cssSelector(".add-to-cart")).click();
		
//		List<WebElement> products = driver.findElements(By.cssSelector(".productinfo"));
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("p")).getText().equals("Blue Top")).findFirst()
//				.orElse(null);
//		
//		
//		prod.findElement(By.cssSelector("a[href*='/product_details']")).click();
//		System.out.println(prod.getText());
////
////		prod.findElement(By.cssSelector("add-to-cart")).click();
//		new Actions(driver).moveToElement(prod).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart")));
//		prod.findElement(By.cssSelector(".add-to-cart")).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-center a")));
//		driver.findElement(By.cssSelector(".text-center a")).click();
////		driver.findElement(By.cssSelector(".modal-content .btn-success")).click();

//		// Contact us
//		List<WebElement> aTags = driver.findElements(By.cssSelector(".shop-menu a"));
//		aTags.stream().filter(aTag -> aTag.getText().equals("Contact us")).findFirst().get().click();
//
//		
//		searProductPage()
//		driver.findElement(By.cssSelector("input[name= 'name']")).sendKeys("dev");
//		driver.findElement(By.cssSelector("input[name= 'email']")).sendKeys("dev@gmail.com");
//		driver.findElement(By.cssSelector("input[name= 'subject']")).sendKeys("Product subject");
//		driver.findElement(By.id("message")).sendKeys("good products");
//		driver.findElement(By.cssSelector("input[name= 'submit']")).click();
//		driver.switchTo().alert().accept();
//		driver.findElement(By.cssSelector(".alert-success")).getText();
//		driver.findElement(By.cssSelector(".btn-success")).click();

//		viewProduct and quantity

	}

	public static void RegisterUser() {

		// Register User code
		driver.findElement(By.cssSelector(".signup-form input[type ='text']")).sendKeys("Testing User1");
		driver.findElement(By.cssSelector(".signup-form input[type ='email']")).sendKeys("Testinguser1@outlook.com");
		driver.findElement(By.cssSelector(".signup-form button[type = \"submit\"]")).click();

		driver.findElement(By.cssSelector(".radio input[value = 'Mr']")).click();

		// Check user name
		System.out.println(driver.findElement(By.id("name")).getText());
		System.out.println(driver.findElement(By.id("email")).getText());

		// Password
		driver.findElement(By.id("password")).sendKeys("testPass");

		// Date of birth
		driver.findElement(By.cssSelector(".selector select[name='days'] option:nth-child(7)")).click();
		driver.findElement(By.cssSelector(".selector select[name='months'] option:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".selector select[name='years'] option:nth-child(23) ")).click();

		driver.findElement(By.id("first_name")).sendKeys("Test");
		driver.findElement(By.id("last_name")).sendKeys("User");
		driver.findElement(By.id("company")).sendKeys("Amdocs");
		driver.findElement(By.id("address1")).sendKeys("test add");
		driver.findElement(By.id("address2")).sendKeys("Test add");

//				driver.findElement(By.cssSelector(".form-control option[value =['India']")).click();

		driver.findElement(By.id("state")).sendKeys("MP");
		driver.findElement(By.id("city")).sendKeys("Jabalpur");
		driver.findElement(By.id("zipcode")).sendKeys("482001");
		driver.findElement(By.id("mobile_number")).sendKeys("123456789");

		driver.findElement(By.xpath("//button[text()='Create Account']")).click();

	}

	public static void contactUs() {

	}

	public static void searProductPage() {
		// Serach product on product page
		driver.findElement(By.cssSelector("a[href*='/p']")).click();
		driver.findElement(By.id("search_product")).sendKeys("Blue");
		driver.findElement(By.id("submit_search")).click();
		List<WebElement> productsOnSearchPage = driver.findElements(By.cssSelector(".productinfo p"));
//		productsOnSearchPage.stream().filter(prod -> prod.getText().contains("Blue"));

		Boolean productMatch = productsOnSearchPage.stream().anyMatch(prod -> prod.getText().contains("Blue"));
		Assert.assertTrue(productMatch);
	}

}
