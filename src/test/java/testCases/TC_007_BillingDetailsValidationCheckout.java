package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import testBase.BaseClass;

public class TC_007_BillingDetailsValidationCheckout extends BaseClass {
    @Test
    public void fillingBillingFormForCheckout() throws InterruptedException {
        logger.info("****Starting TC_007_BillingDetailsValidationCheckoutPage ***** ");
        logger.info("****Logging to the page***** ");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(rb.getString("email"));
        lp.setPassword(rb.getString("pwd"));
        lp.clickLogin();
        logger.info("**Searching for the product from my account page***");
        MyAccountPage macc = new MyAccountPage(driver);
        macc.searchProduct();
        macc.clickSearch();
        ProductDisplaypage pd = new ProductDisplaypage(driver);
        logger.info("***Adding product to the cart***");
        pd.clickAddToCart();
        pd.clickCartBtn();
        pd.clickCheckoutLnk();

        logger.info("***Filling the form for ckeckout****");

        CheckoutFillingFormPage form = new CheckoutFillingFormPage(driver);

        form.clickNewAdrsRadioBtn();

        form.setFstName(rb.getString("firstname"));
        form.setLstname(rb.getString("lastname"));
        form.setAddress1(rb.getString("addressLine"));
        form.setCity(rb.getString("cityLine"));
        form.setPostCode(rb.getString("postcodeLine"));
        form.setSelectCountry();
        form.setSelectState();
        form.clickPaymentBtn();

        form.clickBillingDetailsCnt();
        Thread.sleep(1000);
        form.clickDeliveryDetailsBtn();
        Thread.sleep(1000);
        form.clickDeliveryMethodBtn();
        Thread.sleep(1000);

        form.clickTermSAndConditions();
        Thread.sleep(1000);
        form.clickPaymentMethodCntBtn();
        Thread.sleep(1000);
        form.clickOrderConfirmBtn();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        form.clickOrderConfirmBtn();

        String confmsg = form.getOrderPlacedMsg();
        Thread.sleep(3000);

        Assert.assertEquals(confmsg, "Your order has been placed!");

      /*  if (confmsg.equals("Your order has been placed!")) {
            logger.info("test Passed");
            Assert.assertTrue(true);
        } else {
            logger.error("test failed");
            Assert.assertTrue(false);
        }

       */




        logger.info("*****Finished TC_007_BillingDetailsValidationCheckout ");


    }
}

