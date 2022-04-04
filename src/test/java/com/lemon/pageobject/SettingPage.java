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
 * @Create: 2022-04-02 16:54
 * @Desc：
 **/

public class SettingPage extends BasePage {
    //1.退出登录按钮
    By quitLoginBy = MobileBy.id("com.lemon.lemonban:id/logout_button");
    //2.退出确认按钮
    By quitComfirmBy = MobileBy.id("com.lemon.lemonban:id/tv_sure");

    /**
     * 设置页面-----退出登录操作
     */
    public void quitLogin(){
        click("设置页面-退出登录按钮",quitLoginBy);
        click("设置页面-确认退出",quitComfirmBy);
    }
}
