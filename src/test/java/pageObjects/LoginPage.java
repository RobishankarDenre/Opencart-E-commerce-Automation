package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='input-email']")
	WebElement mailId;

	@FindBy(how = How.XPATH, using = "//input[@id='input-password']")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement clickLogin;

	public void setMailId(String mail) {
		mailId.sendKeys(mail);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		clickLogin.click();
	}

}
