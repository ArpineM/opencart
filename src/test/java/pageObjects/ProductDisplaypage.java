package pageObjects;

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

    public boolean successMsgIsDisplayed() {
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

}
