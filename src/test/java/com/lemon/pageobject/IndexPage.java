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
 * @Create: 2022-04-01 21:01
 * @Desc：
 **/

public class IndexPage extends BasePage {            //IndexPage默认首页
    //1.我的柠檬
    By mylemonBy = MobileBy.AccessibilityId("我的柠檬");      //id定位，通过元素的content-desc属性定位
    //2.点击头像登录
    By avatarLogin = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout");
    //3.用户名元素
    By userNameBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");
    //4.题库
    By tikuBy = MobileBy.AccessibilityId("题库");

    /**
     * 进入到登录页面
     */
    public void enterLoginPage(){
        click("首页页面-我的柠檬",mylemonBy);
        click("首页页面-头像登录",avatarLogin);
    }

    /**
     * 获取用户名文本
     * @return
     */
    public String getUserNameText() {
        return getElementText("首页页面-用户名",userNameBy);
    }

    /**
     * 进入到我的柠檬页面
     */
    public void enterMyLemonPage(){
        click("首页页面-我的柠檬",mylemonBy);
    }

    /**
     * 进入到题库页面
     */
    public void enterTikuPage(){
        click("首页页面-题库",tikuBy);
    }


}
