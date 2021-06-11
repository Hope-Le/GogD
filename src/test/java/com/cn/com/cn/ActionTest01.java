package com.cn.com.cn;

import auto.test.action.Action;
import auto.test.driver.SeleniumDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActionTest01 {

    @DataProvider(name="test02")
    public Object[][] data(){
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    WebDriver driver;

    @Test(dataProvider = "test02")
    public void actionTest(String bro) throws InterruptedException {
        driver= SeleniumDrivers.openBrower(bro);
        driver.get("https://www.baidu.com/");
        Action.sendkey(SearchPage.loginName,"selenium test");
        Action.click(SearchPage.loginBtn,"你点击了百度一下");
        Thread.sleep(3000);
        SeleniumDrivers.closed();
    }

}
