package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutFillingFormPage extends BasePage {
    public CheckoutFillingFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "firstname")
    WebElement fstName;
    @FindBy(name = "lastname")
    WebElement lstname;
    @FindBy(xpath = "//input[@name='address_1']")
    WebElement address1;
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postCode;
    @FindBy(xpath = "//select[contains(@name,'country_id')]")
    WebElement countries;
    Select selectCountry = new Select(countries);

    @FindBy(xpath = "//select[@name='zone_id']")
    WebElement states;
    Select selectState = new Select(states);
    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement paymentCntBtn;


    @FindBy(xpath = "//div[@id='collapse-payment-address']//input[@id='button-payment-address']")
    WebElement billingDetailsContinueBtn; //billing details continue
    @FindBy(xpath = "//input[@id='button-shipping-address']")
    WebElement deliveryDetailsBtn; //deliverydetails continue

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement deliveryMethodCntBtn; //delivery method cont
    @FindBy(xpath = "//div[@class='buttons']//input[@name='agree']")
    WebElement termsAndCond; //terms and conditions checkbox
    @FindBy(xpath = "//div[@class='buttons']//input[@id='button-payment-method']")
    WebElement paymentMethodCntBtn; //payment method cont
    @FindBy(xpath = "//div[@class='pull-right']//input[@id='button-confirm']")
    WebElement orderConfirmBtn; //order confirm button
    @FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
    WebElement orderPlacedMsg;
    @FindBy(xpath = "(//input[@name='payment_address'])[2]")
    WebElement newAddressBtn;

    public void setFstName(String firstname) {
        fstName.sendKeys(firstname);

    }

    public void setLstname(String lastName) {
        lstname.sendKeys(lastName);
    }

    public void setAddress1(String addressLine) {
        address1.sendKeys(addressLine);
    }

    public void setCity(String cityLine) {
        city.sendKeys(cityLine);
    }

    public void setPostCode(String postcodeLine) {
        postCode.sendKeys(postcodeLine);
    }

    public void setSelectCountry() {
        selectCountry.selectByVisibleText("United States");
    }

    public void setSelectState() {
        selectState.selectByVisibleText("Florida");
    }

    public void clickPaymentBtn() {
        paymentCntBtn.click();
    }

    public void clickBillingDetailsCnt() {
        executor.executeScript("arguments[0].click;", billingDetailsContinueBtn);
    } //billing details



    public void clickDeliveryDetailsBtn() {
        //WebElement btn = this.driver.findElement(By.xpath("//input[@id='button-shipping-address']"));
        deliveryDetailsBtn.click();
        //executor.executeScript("arguments[0].click;", deliveryDetailsBtn);
       //delivery details

    }
    public void clickDeliveryMethodBtn(){
        //WebElement btn = this.driver.findElement(By.xpath("//input[@id='button-shipping-method']"));
        deliveryMethodCntBtn.click();
        //executor.executeScript("arguments[0].click;",deliveryMethodCntBtn);
        //delivery method
    }

    public void clickTermSAndConditions() {
        executor.executeScript("arguments[0].click();", termsAndCond);
    }

    public void clickPaymentMethodCntBtn() {
        executor.executeScript("arguments[0].click();", paymentMethodCntBtn);
    }

    public void clickOrderConfirmBtn() {
        executor.executeScript("arguments[0].click();", orderConfirmBtn);
    }

    public String getOrderPlacedMsg() {
        try {
            return (orderPlacedMsg.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }

    }
    public void clickNewAdrsRadioBtn(){
        executor.executeScript("arguments[0].click();", newAddressBtn);
    }
}
