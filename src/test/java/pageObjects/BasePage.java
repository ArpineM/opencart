package pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    JavascriptExecutor executor;
   public BasePage(WebDriver driver){
        this.driver=driver;
       this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver,this);
    }

}
