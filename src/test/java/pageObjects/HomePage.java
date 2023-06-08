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
    @FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[2]//i[1]")
    WebElement addToWishList;
    @FindBy(xpath = "//a[@id='wishlist-total']")
    WebElement wishList;

    @FindBy(xpath = "a[class='btn btn-default']")
    WebElement openCartbtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SuccessMSG;

    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }


    public void clickLogin() {
        lnkLogin.click();
    }

    public void clearSearchField() {
        searchField.clear();
    }

    public void searchProduct() {
        searchField.sendKeys("iMac");


    }

    public void searchClick() {
        SearchBtn.click();

    }

    public void addingToWishList() {
        addToWishList.click();
    }

    public void clickWishList() {
        wishList.click();
    }

    public boolean openCartbtnisDisplayed() {
        try {
            return openCartbtn.isDisplayed();
        } catch (Exception e) {
            return (false);
        }
    }

    public boolean productInWishListMsg(){
        try {
            return SuccessMSG.isDisplayed();
        }catch(Exception e){
            return (false);
        }
    }
}
