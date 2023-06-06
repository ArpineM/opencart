package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.ProductDisplaypage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_SearchTest extends BaseClass {
    @Test
    public void SearchTest(){
        logger.info("****Searching for the product*****");
        try {
            HomePage hp = new HomePage(driver);
            hp.clearSearchField();
            hp.searchProduct();
            hp.searchClick();

            ProductDisplaypage fp = new ProductDisplaypage(driver);
            Boolean targetProduct = fp.isProductExists();
            Assert.assertEquals(targetProduct, true);
        }
        catch(Exception e){
            Assert.fail();
        }
        logger.info("***Finished Product Search****");

    }

}
