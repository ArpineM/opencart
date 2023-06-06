package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test(groups={"Regression"})
    public void text_account_Registration() {
        logger.info("******Starting TC_001_AccountRegistrationTest*****");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account link");
            hp.clickRegister();

            logger.info("Clicked on Registration Link");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details");
            regpage.setFirstName(randomString().toLowerCase());
            regpage.setLastName(randomString().toUpperCase());
            regpage.setEmail(randomAlphaNumeric() + "@gmail.com");
            regpage.setTelephone(randomNumber());
            String pwd = randomAlphaNumeric();
            regpage.setPassword(pwd);
            regpage.setConfirmPassword(pwd);
            regpage.setPrivacyPolicy();
            regpage.clickContinue();
            logger.info("Clicked on Continue btn");
            String confmsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
            if(confmsg.equals("Your Account Has Been Created!")){
                logger.info("test Passed");
                Assert.assertTrue(true);
            }
            else{
                logger.error("test failed");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("******Finished TC_001_AccountRegistrationTest*****");

    }
}
