package Package.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Package.TestComponents.BaseTest;
import PageObjects.CartPage;
import PageObjects.ProductsPage;

public class ErrorValidations extends BaseTest {

	@Test(dataProvider = "getData")
	public void LoginValidationFailCheck(HashMap<String, String> input) {
		String userEmail = "deva@gmail.com";
		String userPassword = "Deva@120612";

		homePage.login(userEmail, userPassword);

		System.out.println(homePage.getLoginErrorMessage());
		Assert.assertEquals("Your email or password is incorrect!", homePage.getLoginErrorMessage());
	}

	@Test(dataProvider = "getData")
	public void ProductErrorValidationCart(HashMap<String, String> input) {
		ProductsPage productPage = homePage.login(input.get("email"), input.get("password"));
		productPage.getProductsList();
		productPage.addProductToCart(input.get("product"));
		CartPage cartPage = productPage.goToCart();
		Boolean match = cartPage.verfiyProductsDisplay(input.get("product"));
		Assert.assertTrue(match);
	}

	@DataProvider()
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Package//data//Data.json");

		return new Object[][] { { data.get(1) } };

	}

}
