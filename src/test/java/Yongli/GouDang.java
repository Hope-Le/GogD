package keji.goudan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GouDang {

    WebDriver driver;

    //在每个用例执行之前 先执行，打开浏览器
    @BeforeMethod
    public void openChrome(){
        //将浏览器驱动加载到程序中，
        System.setProperty("webdriver.chrome.drive","D:\\testing\\chromedriver.exe");

        //得到 谷歌浏览器驱动对象
        //这个对象 非常重要，下面的所有操作都是通过这个driver对象来实现的
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
    }

    //每条用例执行完之后  就执行我，关闭浏览器
    //@AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void SGD() throws InterruptedException {
        driver.get("http://localhost:81/general/ERP/LOGIN/index.php");

        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/table/tbody/tr/td[3]/table[4]/tbody/tr[1]/td[1]/input")).click();

        Thread.sleep(1500);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[2]"));
        driver.switchTo().frame(element);

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"frame1\"]/frame[2]"));
        driver.switchTo().frame(element1);

        driver.findElement(By.xpath("/html/body/table[7]/tbody/tr/td[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"MENU_66d\"]/tbody/tr/td/table[1]/tbody/tr/td[4]/a")).click();

        driver.switchTo().defaultContent();

        Thread.sleep(1500);

        //点击新建按钮
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(element4);

        WebElement element5 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(element5);

        driver.findElement(By.xpath("//*[@id=\"table\"]/thead[1]/tr/td/table/thead/tr/td[1]/input[1]")).click();

        Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[4]/td[2]/input")).sendKeys("小南");

        WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[5]/td[2]/select"));

        Thread.sleep(500);
        Select select = new Select(ele2);
        select.selectByValue("9");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[6]/td[2]/p/input[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[7]/td[2]/input")).sendKeys("深圳");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[8]/td[2]/input")).sendKeys("525200");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[9]/td[2]/input")).sendKeys("6666");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[10]/td[2]/input")).sendKeys("8888");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[11]/td[2]/input")).sendKeys("www.aqq.com");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[12]/td[2]/input")).sendKeys("工商");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[13]/td[2]/input")).sendKeys("10086");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[14]/td[2]/a[1]")).click();
        //获取第一个页面的句柄
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        Thread.sleep(1000);

        //for循环判定是否为第一页面句柄，如果不是就控制权转交
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(windowHandle)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        //把控制权转交给iframe界面，如果没有id和属性值，把整个iframe当作一个元素来定位
        WebElement ele12 = driver.findElement(By.xpath("//*[@id=\"bottom\"]/frameset/frame[2]"));
        driver.switchTo().frame(ele12);
        driver.findElement(By.xpath("//*[@id=\"admin\"]")).click();

        driver.switchTo().window(windowHandle);

        WebElement element14 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(element14);

        WebElement element15 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(element15);

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[15]/td[2]/textarea")).sendKeys("呵呵");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[16]/td[2]/input")).sendKeys("全国");

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[17]/td/div/input[1]")).click();

        /*//第一种
        Thread.sleep(2000);
        boolean isExist_reg = false;
        try{
            driver.findElement(By.xpath("//*[contains(.,'" + "圆通" + "')]"));
            isExist_reg = true;
        }catch (Exception e){
            isExist_reg = false;
        }
        Assert.assertEquals(isExist_reg,true);*/

        /*//第二种
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(text,"圆通");*/

        //第三种
        Thread.sleep(2000);
        boolean displayed = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[2]")).isDisplayed();
        System.out.println(displayed);
        Assert.assertEquals(displayed,true);

    }
}
