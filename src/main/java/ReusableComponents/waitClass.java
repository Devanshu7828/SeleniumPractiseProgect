package ReusableComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;

public class waitClass {
	WebDriver driver;

	public waitClass(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public void waitForElementToBeClickable(By addToCartButton) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
	}
	
	public void waitForWebElementToBeClickable(WebElement productPagelink) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(productPagelink));
	}

//	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); this is on driver level
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	@FindBy(css = ".text-center a")
	WebElement goToCartBtn;
	
	public CartPage goToCart() {
		goToCartBtn.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
}
