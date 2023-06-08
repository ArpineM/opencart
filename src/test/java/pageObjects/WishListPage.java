package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.ExecutionException;

public class WishListPage extends BasePage {
    public WishListPage (WebDriver driver){
        super(driver);

    }
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")
    WebElement addToCartBtn;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement cartDropDown;
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    WebElement viewCart;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement productInCartSuccessMsg;
    public void addToCartFromWishList(){
        addToCartBtn.click();
    }
    public void clickCartDD(){
        cartDropDown.click();
    }
    public void clickViewCart(){
        viewCart.click();
    }
    public boolean productIsInCartMsg(){
        try {
            return productInCartSuccessMsg.isDisplayed();
        }catch(Exception e){
            return(false);
        }
    }
}
