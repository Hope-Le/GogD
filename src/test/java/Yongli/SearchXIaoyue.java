package keji.goudan;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchXIaoyue {

    WebDriver driver;

    //在每个用例执行之前 先执行，打开浏览器
//    @BeforeMethod
//    public void openChrome(){
//        //将浏览器驱动加载到程序中，
//        System.setProperty("webdriver.chrome.drive","D:\\testing\\chromedriver.exe");
//
//        //得到 谷歌浏览器驱动对象
//        //这个对象 非常重要，下面的所有操作都是通过这个driver对象来实现的
////        WebDriver driver = new ChromeDriver();
//        driver = new ChromeDriver();
//    }

    //每条用例执行完之后  就执行我，关闭浏览器
    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    //搜索 小月 用例
    //第一种 校验
    @Test
    public void sXiaoyue() throws InterruptedException {
        //1 打开百度搜索页面
        driver.get("https://www.baidu.com/");

        // 2 定位操作
        // 向输入框 输入内容 小月
        //WebElement ele01 = driver.findElement(By.id("kw"));
        // WebElement ele01 = driver.findElement(By.xpath("//*[@id='kw']"));
        WebElement ele01 = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        ele01.sendKeys("小月");

        WebElement ele02 = driver.findElement(By.id("su"));
        ele02.click();

        Thread.sleep(3000);

        // 校验
        String title = driver.getTitle();
        Assert.assertEquals(title,"小月_百度搜索","若得到的title是小月_百度搜索，就通过。否则 不通过");



    }

    // 第二种校验
    @Test
    public void regic() throws InterruptedException {
        //1 打开百度搜索页面
        driver.get("http://192.168.239.134:8080/DagShop06/user?method=registUI");


        driver.findElement(By.id("username")).sendKeys("xiaoyue");
        driver.findElement(By.id("inputPassword3")).sendKeys("123");
        driver.findElement(By.id("confirmpwd")).sendKeys("123");

        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input")).click();

        Thread.sleep(3000);

        // 校验
        //通过xpath 看页面上是否存在某个内容  By.xpath("//*[contains(.,'" + 校验的内容 + "')]")
        boolean  isExi_reg = false;

        try{                             ////*[contains(.,'恭喜你')]
            driver.findElement(By.xpath("//*[contains(.,'" + "恭喜你,注册成功,请登录邮箱完成激活!" + "')]"));
            isExi_reg = true;
        }catch (Exception e){
            isExi_reg = false;
        }

        Assert.assertEquals(isExi_reg,true);

    }

    // 第三种校验
    @Test
    public void regic01() throws InterruptedException {
        //1 打开百度搜索页面
        driver.get("http://192.168.239.134:8080/DagShop06/user?method=registUI");


        driver.findElement(By.id("username")).sendKeys("xiaoyue");
        driver.findElement(By.id("inputPassword3")).sendKeys("123");
        driver.findElement(By.id("confirmpwd")).sendKeys("123");

        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input")).click();

        Thread.sleep(3000);

        // 校验
        //通过某个标签中包裹的内容(getText) 是否与我们预期一致，若一致就通过，否则不通过
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/h3")).getText();
        Assert.assertEquals(text,"恭喜你,注册成功,请登录邮箱完成激活!");


    }

    //第四种 校验
    @Test
    public void AssertTrue()throws InterruptedException{
        driver.get("http://www.baidu.com/");
        //id为su的这个控件是否显示在这个界面上
        Boolean isDisplay=driver.findElement(By.id("su")).isDisplayed();//若有这个元素，则结果为 true.否则为false
        System.out.println(isDisplay);
        //校验百度首页是否存在这个元素
        Assert.assertTrue(isDisplay);
    }

}