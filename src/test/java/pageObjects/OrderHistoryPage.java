package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage{
    public OrderHistoryPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Order History']")
    WebElement orderHistoryConfMsg;
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/i[1]")
    WebElement viewIconLnk;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement orderHistoryContBtn;
    public boolean isOrderHistoryPageMsgDisplayed (){
        try {
            return (orderHistoryConfMsg.isDisplayed());
        }catch(Exception e){
            return(false);
        }
    }
    public void clickViewIconLnk(){
        viewIconLnk.click();
    }
    public void clickOrderHistoryContBtn(){
        orderHistoryContBtn.click();
    }
}
