package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

   @Test(groups ={"Regression","Master"})
   public void test_account_Registration(){
      logger.info("*****Starting TC_001_AccountRegistrationTest ****** ");
      HomePage  hp=new HomePage(driver);
      hp.clickMyAccount();
      logger.info("*****Clicked on My Account****");
      hp.clickRegister();
      logger.info("****Clicked on Register Link****");

      AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
      logger.info("***Providing customer details***");
      regPage.setFirstName(randomString().toUpperCase());
      regPage.setLastName(randomString().toUpperCase());
      regPage.setEmail(randomAlphaNumeric()+"@gmail.com");
      regPage.setTelephone(randomNumber());
      String pwd=randomAlphaNumeric();
      regPage.setPassword(pwd);
      regPage.setConfirmPassword(pwd);
      regPage.setPrivacyPolicy();
      regPage.clickContinue();
      logger.info("***Clicked on continue button***");
      String confirmMsg=regPage.getConfirmMsg();
      if(confirmMsg.equals("Your Account Has Been Created!")){
         logger.info("***Test passed***");
         Assert.assertTrue(true);
      }
      else {
         logger.error("***Test failed***");
         Assert.fail();
      }
      logger.info("*****Finished TC_001_AccountRegistrationTest ****** ");



   }





}
