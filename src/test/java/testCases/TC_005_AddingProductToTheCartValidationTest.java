package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductDisplaypage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

import java.util.function.BooleanSupplier;

public class TC_005_AddingProductToTheCartValidationTest extends BaseClass {
    @Test
    public void AddProductToCart() {
        logger.info("****Adding Product To The Cart****");
        try {
            HomePage hp = new HomePage(driver);
            hp.clearSearchField();
            hp.searchProduct();
            hp.searchClick();

            ProductDisplaypage fp = new ProductDisplaypage(driver);
            Boolean targetProduct = fp.isProductExists();
            Assert.assertEquals(targetProduct, true);
        } catch (Exception e) {
            Assert.fail();
        }
        try{
        ProductDisplaypage pd=new ProductDisplaypage(driver);
        pd.clickAddToCart();
       Boolean targetmsg= pd.successMsgIsDisplayed();
       Assert.assertEquals(targetmsg,true);
       pd.clickCartBtn();
       pd.clickViewCart();

            ShoppingCartPage sp=new ShoppingCartPage(driver);
            sp.productIsInTheCart();
        }catch(Exception e ){
            Assert.fail();
        }






    }
}
