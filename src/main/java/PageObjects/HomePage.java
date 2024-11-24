package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponents.waitClass;

public class HomePage extends waitClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".login-form [name='email']")
	WebElement userEmail;

	@FindBy(css = ".login-form [name='password']")
	WebElement userPassword;

	@FindBy(css = ".login-form button")
	WebElement loginButton;

	@FindBy(css = ".nav li:nth-child(4) a")
	WebElement loginSignupBtn;

	@FindBy(css = "form[method = 'POST' ] p")
	WebElement loginErrorMessage;

	public void goTo() {
		driver.get("https://automationexercise.com/");
	}

	public ProductsPage login(String email, String password) {
		// Click on Signup / Login button
		loginSignupBtn.click();
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();

		ProductsPage productPage = new ProductsPage(driver);
		return productPage;
	}

	public String getLoginErrorMessage() {
		waitForWebElementToAppear(loginErrorMessage);

		return loginErrorMessage.getText();
	}

}
