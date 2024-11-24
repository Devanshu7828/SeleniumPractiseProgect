package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponents.waitClass;

public class CartPage extends waitClass {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart_description h4")
	List<WebElement> cartProducts;

	@FindBy(css = ".check_out")
	WebElement checkoutButton;
	
	@FindBy(css = ".cart_quantity_delete")
	WebElement removeItemButton;
	
	
	
	@FindBy(id = "empty_cart")
	WebElement emtpyCartText ;
	
	@FindBy(css = ".text-center a[href*='/p']")
	WebElement productPagelink;
	

	public boolean verfiyProductsDisplay(String productName) {

		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().contains(productName));

		return match;
	}
	
	public void removeProductFromCart(String productName) {
		verfiyProductsDisplay(productName);
		removeItemButton.click();
		waitForWebElementToBeClickable(productPagelink);
		productPagelink.click();
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutButton.click();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		return checkoutPage;
	}
	
	

}
