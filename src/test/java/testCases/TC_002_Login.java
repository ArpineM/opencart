package testCases;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import org.testng.annotations.*;

public class TC_002_Login extends BaseClass {

    @Test(groups ={"Sanity","Master"})

    public void test_Login(){
        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(rb.getString("email"));
            lp.setPassword(rb.getString("pwd"));
            lp.clickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            Boolean targetPage = myAccountPage.myAccountPageExists();
            Assert.assertEquals(targetPage, true);
        }
        catch(Exception e){
            Assert.fail();
        }

    }



}


