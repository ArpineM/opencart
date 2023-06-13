package testCases;


import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import testBase.BaseClass;

public class TC_008_OrderHistoryPageValidation extends BaseClass {
    @Test
            public void NavigatingToOrderHistoryPage() throws InterruptedException {
        logger.info("****Starting TC_008_OrderHistoryPageValidation ");
        logger.info("****Login in");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(rb.getString("email"));
        lp.setPassword(rb.getString("pwd"));
        lp.clickLogin();
        logger.info("Navigating to order history from myaccount page");
        MyAccountPage macc=new MyAccountPage(driver);
        macc.clickMyAccountDropDown();
        macc.clickMyOrderHistoryFromDD();
        logger.info("****Conformation of the order history page");
        OrderHistoryPage ordHist= new OrderHistoryPage(driver);
        Thread.sleep(3000);
       boolean targetMsg= ordHist.isOrderHistoryPageMsgDisplayed();

        Assert.assertEquals(targetMsg,true);
        logger.info("***Clicking view icon from the order list");
        ordHist.clickViewIconLnk();
        logger.info("****Validating the order Details Page display");
        OrderDetailsPage orderDetails=new OrderDetailsPage(driver);
        Thread.sleep(3000);
      boolean detailsValidation=  orderDetails.isOrderDetailsDisplayed();
      Assert.assertEquals(detailsValidation,true);
      orderDetails.ClickOrderDetailsPageContBtn();
      ordHist.clickOrderHistoryContBtn();

      logger.info("**Navigating to My Account Page");
     boolean targetPage= macc.isMyAccountPageExists();
     Assert.assertEquals(targetPage,true);





    }

}
