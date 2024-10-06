package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(how = How.XPATH, using = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(how = How.XPATH, using = "//input[@id='input-email']")
	WebElement txtMailId;

	@FindBy(how = How.XPATH, using = "//input[@id='input-telephone']")
	WebElement numPhoneNumber;

	@FindBy(how = How.XPATH, using = "//input[@id='input-password']")
	WebElement txtPassWord;

	@FindBy(how = How.XPATH, using = "//input[@id='input-confirm']")
	WebElement txtCnfPassword;

	@FindBy(how = How.XPATH, using = "//label[normalize-space()='Yes']")
	WebElement rdoSubs;

	@FindBy(how = How.XPATH, using = "//input[@name='agree']")
	WebElement cBoxPolicy;

	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement sucMsg;
//	https://tutorialsninja.com/demo/index.php?route=account/success

	public void firstName(String firstname) {
		txtFirstname.sendKeys(firstname);
	}

	public void lastName(String lastname) {
		txtLastname.sendKeys(lastname);
	}

	public void eMail(String mail) {
		txtMailId.sendKeys(mail);
	}

	public void telePhone(String phNo) {
		numPhoneNumber.sendKeys(phNo);
	}

	public void password(String pwd) {
		txtPassWord.sendKeys(pwd);
	}

	public void cnfPassword(String pwd) {
		txtCnfPassword.sendKeys(pwd);
	}

	public void subscribe() {
		rdoSubs.click();
	}

	public void policy() {
		cBoxPolicy.click();
	}

	public void conBtn() {
		btnContinue.click();
	}

	public String sucMsgCof() {
		String sucMsgText = sucMsg.getText();
		return sucMsgText;

	}

}
