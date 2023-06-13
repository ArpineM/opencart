package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BasePage{
    public OrderDetailsPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//td[normalize-space()='Order Details']")
    WebElement orderDetailsMsg;
    @FindBy(xpath = "(//a[normalize-space()='Continue'])[1]")
    WebElement orderDetailsPageContBtn;
    public boolean isOrderDetailsDisplayed(){
        return (orderDetailsMsg.isDisplayed());
    }
    public void ClickOrderDetailsPageContBtn(){
        orderDetailsPageContBtn.click();
    }
}
