package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_006_AddingToWishListFromHomePage extends BaseClass {
    @Test
    public void AddingProductToWishList() {
        logger.info("****Starting TC_006_AddingToWishListFromHomePage***** ");
        logger.info("****Logging to the page***** ");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(rb.getString("email"));
        lp.setPassword(rb.getString("pwd"));
        lp.clickLogin();
        MyAccountPage macc = new MyAccountPage(driver);
        macc.clickLogoImage();
        logger.info("****Adding product to wish list***** ");
        hp.addingToWishList();
        try {
            boolean inWishlistMsg = hp.productInWishListMsg();
            Assert.assertEquals(inWishlistMsg, true);
        } catch (Exception e) {
            Assert.fail();
        }
        hp.clickWishList();
        WishListPage wl = new WishListPage(driver);
        wl.addToCartFromWishList();
        try {

            boolean inCartMsg = wl.productIsInCartMsg();
            Assert.assertEquals(inCartMsg, true);
        } catch (Exception e) {
            Assert.fail();
        }

        wl.clickCartDD();
        wl.clickViewCart();
        logger.info("****Navigating to homepage from shopping cart page***** ");
        boolean targetIcon = false;
        try {
            ShoppingCartPage shc = new ShoppingCartPage(driver);
            shc.clickContShopp();
            targetIcon = hp.openCartbtnisDisplayed();
            Assert.assertEquals(targetIcon, true);
        } catch (Exception e) {
            Assert.assertEquals(targetIcon, false);
        }
        logger.info("****Finishing TC_006_AddingToWishListFromHomePage***** ");


    }
}
