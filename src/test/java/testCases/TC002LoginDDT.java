package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "Regression" })
	public void loginTestDDT(String mail, String pwd, String expRes) {

		HomePage hp = new HomePage(driver);
		try {
			logger.info("*** TC002LoginDDT is starting ***");

			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setMailId(mail);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage account = new MyAccountPage(driver);
			boolean expValue = account.myAccount();

			if (expRes.equalsIgnoreCase("Valid")) {
				if (expValue == true) {
					hp.clickMyAccount();
					account.accLogout();
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			}
			if (expRes.equalsIgnoreCase("Invalid")) {
				if (expValue == true) {
					hp.clickMyAccount();
					account.accLogout();
					assertTrue(false);
				} else {
					assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred : " + e.getMessage());
		} finally {
			logger.info("*** TC002LoginDDT is finished  ***");
		}

	}
}
