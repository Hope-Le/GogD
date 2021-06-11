package com.cn.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class openchrome {

    WebDriver driver;
   // @Test
    public void openchrome(){

        System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://www.sina.com.cn/");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"新浪首页");
    }

    @Test
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\testing\\msedgedriver.exe");
        driver=new EdgeDriver();
        driver.get("http://www.sina.com.cn/");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"新浪首页");
    }

    @AfterTest
    public void closedchrome()throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }

}
