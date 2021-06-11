package com.cn.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Gridhub {

    @DataProvider(name = "browser1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"http://192.168.0.151:8889","chrome"},
                {"http://192.168.0.151:8889","firefox"}
        };
    }
    @Test(dataProvider = "browser1")
    public void testData(String url,String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities;
        if (browser.equals("chrome")){
            desiredCapabilities=DesiredCapabilities.chrome();
        }else if(browser.equals("firefox")){
            desiredCapabilities=DesiredCapabilities.firefox();
            Thread.sleep(6000);
        }else {
            System.out.println("11111111111111111");
            desiredCapabilities = null;
        }
        WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),desiredCapabilities);
        Thread.sleep(6000);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

}
