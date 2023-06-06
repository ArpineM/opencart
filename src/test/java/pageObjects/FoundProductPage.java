package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FoundProductPage extends BasePage {
    public FoundProductPage (WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//img[@title='iMac']")
    WebElement foundProduct;

    public boolean isProductExists(){
        try {
            return (foundProduct.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

}
