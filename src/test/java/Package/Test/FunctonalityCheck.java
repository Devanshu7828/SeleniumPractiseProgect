package Package.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Package.TestComponents.BaseTest;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.ContactUsPage;
import PageObjects.ProductsPage;
import PageObjects.SearchProductPage;

public class FunctonalityCheck extends BaseTest {

	@Test(dataProvider = "getData")
	public void E2EWebsiteTest(HashMap<String, String> input) {

//		ProductsPage productPage = homePage.login("Testinguser1@outlook.com", "testPass");
		ProductsPage productPage = homePage.login(input.get("email"), input.get("password"));
		productPage.getProductsList();
		
		productPage.searchProducts(input.get("product"));
		
		productPage.addProductToCart(input.get("product"));
		// goToCart
		CartPage cartPage = productPage.goToCart();
		Boolean match = cartPage.verfiyProductsDisplay(input.get("product"));
		Assert.assertTrue(match);
		
		//Remove product from cart
		cartPage.removeProductFromCart(input.get("product"));
		
		//Search product and add to cart again
		productPage.searchProducts(input.get("product"));
		productPage.addProductToCart(input.get("product"));
		productPage.goToCart();
		
		CheckoutPage checkouPage = cartPage.goToCheckOut();
		ConfirmationPage confirmPage = checkouPage.placeOrder();
		ContactUsPage contactPage = confirmPage.clickContinueOnConfirmPage();
		contactPage.contactUsPageDetails();
		
		
	}
	
	
	

	@DataProvider()
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Package//data//Data.json");

		return new Object[][] { { data.get(0)} };

	}
}