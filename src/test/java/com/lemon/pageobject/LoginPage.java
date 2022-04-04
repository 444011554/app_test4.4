package com.lemon.pageobject;

import com.lemon.base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-01 19:53
 * @Desc：
 **/

public class LoginPage extends BasePage {             //登录页面


    //1.手机号码输入框
    By mobileBy = MobileBy.id("com.lemon.lemonban:id/et_mobile");
    //2.密码输入框
    By pwdBy = MobileBy.id("com.lemon.lemonban:id/et_password");
    //3.登录按钮
    By loginButtonBy = MobileBy.id("com.lemon.lemonban:id/btn_login");

    public void login(String mobilephone, String pwd){
        type("登录页面-手机号码输入框",mobileBy,mobilephone);
        type("登录页面-密码输入框",pwdBy,pwd);
        click("登录页面-登录按钮",loginButtonBy);
    }

}
