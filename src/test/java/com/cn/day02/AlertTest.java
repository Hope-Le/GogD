package com.cn.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver driver;
    @BeforeTest
    public void openchrome(){
        System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void AlertTest() throws InterruptedException{
        driver.get("file:///D:/testing/selenium_html/index.html");
        WebElement alertButton = driver.findElement(By.className("confirm"));
        alertButton.click();
        //因为无法获取弹出框确定按钮的定位，所以把driver的控制权交给alert
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        //点击确定按钮
        alert.accept();
    }
    @Test
    public void ConfirmTest() throws InterruptedException{
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"confirm\"]/input"));
        confirmButton.click();
        //因为无法获取弹出框确定按钮的定位，所以把driver的控制权交给alert
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        //点击取消按钮,然后弹出警告框，点击确定
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }
    @Test
    public void PromptTest() throws InterruptedException{
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement promptButton = driver.findElement(By.className("prompt"));
        promptButton.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("this is prompt,haha");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }

}
