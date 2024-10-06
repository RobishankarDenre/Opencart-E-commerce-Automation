package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002LoginTest extends BaseClass {

	private MyAccountPage account;

	@Test(groups = {"Regression","Master"})
	public void testLogin() throws InterruptedException {
		logger.info("**** Starting TC_002_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		HomePage hp = new HomePage(driver);
		try {
//		Home Page

			hp.clickMyAccount();
			hp.clickLogin();

//		Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setMailId(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

//		MyAccount
			account = new MyAccountPage(driver);

			boolean targetPage = account.myAccount();
			assertEquals(targetPage, true, "Login Failed");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Logout ****");
		hp.clickMyAccount();
		Thread.sleep(Duration.ofSeconds(1));
		account.accLogout();
		logger.info("*** Account Logout Successfully ***");
	}

}
