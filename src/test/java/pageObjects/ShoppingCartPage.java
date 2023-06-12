package pageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
    WebElement productInCart;
    @FindBy(xpath = "a[class='btn btn-default']")
    WebElement continueShopping;
    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    WebElement checkoutBtn;

    public boolean productIsInTheCart() {
        try {
            return productInCart.isDisplayed();
        }
        catch(Exception e){
            return (false);
        }
    }
    public void clickContShopp(){
        continueShopping.click();
    }
    public void clickCheckout(){
        checkoutBtn.click();
    }


}
