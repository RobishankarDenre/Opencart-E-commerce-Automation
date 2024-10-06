package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='My Account']")
	WebElement myAcc;

	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement lknlogout;

	public boolean myAccount() {
		try {
			return myAcc.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void accLogout() {
		lknlogout.click();
	}

}
