package com.cn.day03;



import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public void gridTest() throws MalformedURLException, InterruptedException {
        /*DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.191.3:4444/wd/hub"),fireFoxDC);*/
        DesiredCapabilities chromeDC=DesiredCapabilities.chrome();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.227:8889/wd/hub"),chromeDC);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void gridTest00() throws MalformedURLException, InterruptedException {
        DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.227:8889/wd/hub"),fireFoxDC);
        Thread.sleep(3000);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void gridTest01() throws MalformedURLException, InterruptedException {
        /*DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.191.3:4444/wd/hub"),fireFoxDC);*/
        DesiredCapabilities edgeDC=DesiredCapabilities.edge();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.10.145:4445/wd/hub"),edgeDC);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

//    @Test
//    public void gridTest02() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "edge");
//        //seting the required capabilities
////        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();
//        options.merge(caps);
//        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.107:4445/wd/hub"),  options);
//        driver.get("http://www.baidu.com");
//        Thread.sleep(5000);
//        driver.quit();
//    }







}
