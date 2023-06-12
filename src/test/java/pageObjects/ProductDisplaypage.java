package pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplaypage extends BasePage {
    public ProductDisplaypage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//img[@title='iMac']")
    WebElement foundProduct;

    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMsg;
    @FindBy(xpath = "//span[@id='cart-total']")
    WebElement cartBtn;
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement viewCartlnk;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4] ")
    WebElement shoppingCart;
    @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
    WebElement checkoutLnk;

    public boolean isProductExists(){
        try {
            return (foundProduct.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }
    public void clickAddToCart(){
        addToCartBtn.click();
    }

    public boolean productIsInCartMsg() {
        try {
            return (successMsg.isDisplayed());
        } catch(Exception e){
            return (false);
    }
    }
    public void clickCartBtn(){
        cartBtn.click();
    }
    public void clickViewCart(){
        viewCartlnk.click();
    }
    public void clickShoppingCart(){
        shoppingCart.click();
    }
    public void clickCheckoutLnk(){
        checkoutLnk.click();
    }

}
