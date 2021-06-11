package Yongli;

import auto.test.action.Action;
import auto.test.driver.SeleniumDrivers;
import com.cn.com.cn.LoginPage;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Yongli {
    @DataProvider(name ="driver")
    public  Object[][] data(){
        return  new Object[][]{
                {"chrome"} ,{"firefox"}

        };
    }
    WebDriver driver;


    @Test(dataProvider = "driver")
    public void LongText(String dr) throws InterruptedException {
        WebDriver driver = SeleniumDrivers.openBrower(dr);
        driver.get("http://192.168.239.134:8080/DagShop06/user?method=loginUI");
        Action.sendkey(LoginPage.loginName,"1");
        Action.sendkey(LoginPage.loginPwd,"1");
        Action.click(LoginPage.loginBtn,"登录");
        Thread.sleep(3000);
        SeleniumDrivers.closed();
    }

    @Test
    public void LongTextA(String dr) throws InterruptedException {
        WebDriver driver = SeleniumDrivers.openBrower(dr);
        driver.get("https://dev.bnzedu.com/admin/#/login");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[2]/div/div/span/span/input")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[3]/div/div/span/span/input")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[4]/div/div/span/button")).click();

        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/aside/div/ul/li[2]/div[1]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/aside/div/ul/li[2]/ul/li[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/div[1]/div[1]/a/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/div[2]/button[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[1]/div[2]/div/span/input")).sendKeys("语文");
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[3]/div[2]/div/span/div/form/div[1]/div[2]/div/span/span/input")).sendKeys("10");
        driver.findElement(By.xpath(" //*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[3]/div[2]/div/span/div/form/div[2]/div[2]/div/span/span/input")).sendKeys("20");

        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[3]/div[2]/div/span/div/form/div[3]/div[2]/div/span/span/input")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[4]/div/div/span/button")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/span/label/span/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/section/main/div/form/div[6]/div/div/span/button[2]")).click();

    }


}
