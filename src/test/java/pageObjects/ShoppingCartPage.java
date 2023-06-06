package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")
    WebElement productInCart;

    public boolean productIsInTheCart() {
        try {
            return productInCart.isDisplayed();
        }
        catch(Exception e){
            return (false);
        }


    }


}
