package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ReusableComponents.waitClass;

public class ProductsPage extends waitClass {
	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".productinfo")
	List<WebElement> products;

	By waitProducts = By.cssSelector(".productinfo");

	By waitAddTocart = By.cssSelector(".add-to-cart");

//	@FindBy(css = ".add-to-cart")
	By addToCartButton = By.cssSelector(".add-to-cart");

	@FindBy(css = "a[href*='/p']")
	WebElement productLink;

	@FindBy(id = "search_product")
	WebElement searchProduct;

	@FindBy(id = "submit_search")
	WebElement clickOnSearchBtn;

	@FindBy(css = ".productinfo p")
	List<WebElement> retrirvedSearchProducts;

	@FindBy(css = "a[href*='/']")
	WebElement homePageLink;

	public List<WebElement> getProductsList() {

		waitForElementToAppear(waitProducts);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("p")).getText().equals(productName)).findFirst()
				.orElse(null);

		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		new Actions(driver).moveToElement(prod).perform();

		waitForElementToBeClickable(addToCartButton);
		prod.findElement((addToCartButton)).click();

	}

	public void searchProducts(String productName) {
		getProductsList();
		productLink.click();
		searchProduct.sendKeys(productName);
		clickOnSearchBtn.click();


	}

}
