package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.name("name_on_card"));
	// driver.findElement(By.name("card-number"));
	// driver.findElement(By.name("cvc"));
	// driver.findElement(By.name("expiry_month"));
	// driver.findElement(By.name("expiry_year"));
	@FindBy(css = ".check_out")
	WebElement placeOrderBtn;

	@FindBy(name = "name_on_card")
	WebElement nameOnCard;
	@FindBy(name = "card_number")
	WebElement cardNumber;
	@FindBy(name = "cvc")
	WebElement CVC;
	@FindBy(name = "expiry_month")
	WebElement expiryMonth;
	@FindBy(name = "expiry_year")
	WebElement expiryYear;

	@FindBy(id = "submit")
	WebElement payAndConfirmButton;

	public ConfirmationPage placeOrder() {

		// Click on Place Order button
		placeOrderBtn.click();
		// Fill credit card details
		nameOnCard.sendKeys("Devanshu");
		cardNumber.sendKeys("3214563263");
		CVC.sendKeys("324");
		expiryMonth.sendKeys("12");
		expiryYear.sendKeys("2028");

		payAndConfirmButton.click();

		ConfirmationPage confirmPage = new ConfirmationPage(driver);
		return confirmPage;

	}

}
