package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationPage extends BasePage{
   public AccountRegistrationPage (WebDriver driver) {
       super(driver);
   }
   @FindBy(name = "firstname")
    WebElement txtFirstname;
   @FindBy(name="lastname")
    WebElement txtLastname;
   @FindBy(name="email")
   WebElement txtEmail;
   @FindBy(name="telephone")
    WebElement txtTelephone;
   @FindBy(name="password")
    WebElement txtPassword;
   @FindBy(name="confirm")
    WebElement txtPasswordConfirm;
   @FindBy(name="agree")
    WebElement checkPolicy;
   @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;
   @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement confMessage;

   public void setFirstName(String fname){
       txtFirstname.sendKeys(fname);
   }
   public void setLastName(String lname){
       txtLastname.sendKeys(lname);
   }
   public void setEmail(String email){
       txtEmail.sendKeys(email);
   }
   public void setTelephone(String telephone){
       txtTelephone.sendKeys(telephone);
   }
   public void setPassword(String pwd){
       txtPassword.sendKeys(pwd);
   }
   public void setConfirmPassword(String pwd2){
       txtPasswordConfirm.sendKeys(pwd2);
   }
   public void setPrivacyPolicy(){
       checkPolicy.click();
   }
   public void clickContinue(){
       btnContinue.click();
   }
   public String getConfirmMsg(){
       try{
       return confMessage.getText();
   }
       catch(Exception e){
           return(e.getMessage());
       }

       }

}
