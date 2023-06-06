package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;
    @FindBy(linkText = "Register")
    WebElement lnkRegister;

    @FindBy(linkText = "Login")
    WebElement lnkLogin;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchField;
    @FindBy(xpath = "(//button[@class='btn btn-default btn-lg'])[1]")
    WebElement SearchBtn;

    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }


    public void clickLogin() {
        lnkLogin.click();
    }

    public void clearSearchField(){
        searchField.clear();
    }
    public void searchProduct(){
        searchField.sendKeys("iMac");


    }
    public void searchClick(){
        SearchBtn.click();

    }
}
