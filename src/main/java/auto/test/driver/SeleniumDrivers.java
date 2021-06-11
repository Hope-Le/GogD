package auto.test.driver;

import auto.test.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDrivers {

    public static WebDriver driver;
    final static LoggerControler log= LoggerControler.getLogger(SeleniumDrivers.class);
//打开游览器的函数
    public static WebDriver openBrower(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\YouLanQuDong\\chromedriver.exe");
            driver=new ChromeDriver();
            log.info("你打开了"+browser+"浏览器");
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//            System.setProperty("webdriver.gecko.driver","D:\\selenium_jar\\geckodriver.exe");
            driver=new FirefoxDriver();
            log.info("你打开了"+browser+"浏览器");
        }else {
            log.severe("你输入的"+browser+"浏览器不支持打开");
        }
        return driver;
    }
    public static void closed(){
        driver.quit();
    }

}
