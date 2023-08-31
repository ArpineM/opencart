package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void test_LoginDDT(String email, String pwd, String exp) {
        logger.info(" Starting TC_003_LoginDataDrivenTest ");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);

            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetpage = myAccountPage.myAccountPageExists();// this method is created MyAccountPage
            logger.info(email + " " + pwd + " " + exp + " " + targetpage);
            if (exp.equals("Valid")) {
                Assert.assertTrue(targetpage);
                myAccountPage.clickLogout();
            } else if (exp.equals("Invalid")) {
                Assert.assertFalse(targetpage);
            }

        } catch (Exception e) {
            Assert.fail();
        }

        logger.info(" Finished TC_003_LoginDataDrivenTest");

    }

}
