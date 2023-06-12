package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogout;

    @FindBy(xpath = "//img[@title='Your Store']")
    WebElement logoImage;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement maccSearchbtn;


    public boolean isMyAccountPageExists()   // MyAccount Page heading display status
    {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public void clickLogout() {
        lnkLogout.click();
    }
    public void clickLogoImage(){
        logoImage.click();
    }

    public void searchProduct(){
        searchField.sendKeys("iMac");
    }
    public void clickSearch(){
        maccSearchbtn.click();
    }

}
