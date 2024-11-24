package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-sm-9 h2")
	WebElement confirmOrderHeadText;

	@FindBy(css = ".btn-primary")
	WebElement continueButton;

	public void getConfirmOrderText() {
		String orderConfText = confirmOrderHeadText.getText();
		System.out.println(orderConfText);

	}

	public ContactUsPage clickContinueOnConfirmPage() {
		
		getConfirmOrderText();
		continueButton.click();
		
		ContactUsPage contact = new ContactUsPage(driver);
		
		return contact;
		
	}
	
	

}
