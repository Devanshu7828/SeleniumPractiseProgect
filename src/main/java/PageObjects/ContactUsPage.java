package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableComponents.waitClass;

public class ContactUsPage extends waitClass {
	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".shop-menu a")
	List<WebElement> anchorTags;

	@FindBy(css = "input[name= 'name']")
	WebElement name;

	@FindBy(css = "input[name= 'email']")
	WebElement email;

	@FindBy(css = "input[name= 'subject']")
	WebElement subject;

	@FindBy(id = "message")
	WebElement message;

	@FindBy(css = ".alert-success")
	WebElement sucessText;

	@FindBy(css = "input[name= 'submit']")
	WebElement submitButton;

	@FindBy(css = ".btn-success")
	WebElement homeButton;

	public void contactUsPageDetails() {
		anchorTags.stream().filter(contact -> contact.getText().equals("Contact us")).findFirst().get().click();
		name.sendKeys("Devanshu Rajak");
		email.sendKeys("Rajakd@amdocs.co");
		;
		subject.sendKeys("Get contact of company");
		message.sendKeys("Please contact back");
		submitButton.click();
		driver.switchTo().alert().accept();
		System.out.println(sucessText.getText());
		homeButton.click();
		
//		SearchProductPage serachProductPage = new SearchProductPage(driver);
//		return serachProductPage;
	}

}
