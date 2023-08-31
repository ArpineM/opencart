package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {
    public Logger logger;
    public static WebDriver driver;
    public ResourceBundle rb;


    @BeforeClass
    @Parameters("browser")

    public void setup(String br){
       rb= ResourceBundle.getBundle("config");
        logger= LogManager.getLogger(this.getClass());
        if(br.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
            driver = new ChromeDriver(options);
        }
        else if(br.equalsIgnoreCase("edge")){
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
            driver =new EdgeDriver(options);

        }
        else{
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(rb.getString("appURL"));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }
    public String randomString(){
        String generatedString=RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }
    public String randomNumber(){
        String generatedNumber=RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }
    public String randomAlphaNumeric(){
        String generatedString=RandomStringUtils.randomAlphabetic(5);
        String generatedNumber=RandomStringUtils.randomNumeric(10);
        return (generatedNumber+generatedString);
    }
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
}
