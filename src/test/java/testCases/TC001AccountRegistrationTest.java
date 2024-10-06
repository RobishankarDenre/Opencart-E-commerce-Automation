package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass {
	@Test(groups = { "Sanity", "Master" })
	public void testRegistration() throws InterruptedException {
		try {
			logger.info("**** TC001AccountRegistrationTest Testing Starting ****");
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");
			home.clickRegistration();
			logger.info("Clicked on Register Link.. ");

			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			logger.info("**** Fill the Details of Registration ****");
			arp.firstName(genRandomString().toUpperCase());
			arp.lastName(genRandomString().toUpperCase());
			arp.eMail(genRandomString().toLowerCase() + "@gmail.com");
			arp.telePhone(genRandomNumber());
			String genPassword = genPassword();
			arp.password(genPassword);
			arp.cnfPassword(genPassword);
			arp.subscribe();
			arp.policy();
			Thread.sleep(Duration.ofSeconds(1));
			arp.conBtn();
			logger.info("Validating expected message..");
			String sucMsgCof = arp.sucMsgCof();

			if (sucMsgCof.equals("Your Account Has Been Created!")) {
				logger.info("Checking Confirmation message of Account Creation");
				assertTrue(true);
				logger.info("Test Passed");
			} else {
				logger.info("Checking Confirmation message of Account Creation");
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				assertTrue(false);
			}
		} catch (Exception e) {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} finally {
			logger.info("**** TC001AccountRegistrationTest Testing Finished ****");
		}

	}
}
