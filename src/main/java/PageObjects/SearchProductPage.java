package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SearchProductPage   {
	
	WebDriver driver;

	public SearchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
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
	
	

	public void searchProducts() {
		productLink.click();
		searchProduct.sendKeys("Blue");
		clickOnSearchBtn.click();
		Boolean productsMatch = retrirvedSearchProducts.stream().anyMatch(prod -> prod.getText().contains("Blue"));
		Assert.assertTrue(productsMatch);
		homePageLink.click();
	}
	
	
}
