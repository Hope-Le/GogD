package com.cn.com.cn;

import org.openqa.selenium.By;


public class LoginPage {
    //PO思想实现，当页面元素id或者位置发生变化时，只改这一个地方即可。别的地方调用直接是LoginPage.loginName即可
    public static By loginName=By.name("username");
    public static By loginPwd=By.name("password");
    public static By loginBtn=By.xpath("/html/body/div[3]/div/div[2]/div/form[1]/div[5]/div/input");
}
