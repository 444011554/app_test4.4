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
 * @Create: 2022-04-02 16:34
 * @Desc：
 **/

public class MyLemonPage extends BasePage {
    //1.右上角设置按钮
    By settingBy = MobileBy.xpath("//*[@resource-id='com.lemon.lemonban:id/mypage_titlebar']//android.widget.ImageButton");

    //收藏元素数量      collection收藏    Count计数
    By collectionCountBy = MobileBy.id("com.lemon.lemonban:id/fragment_my_lemon_collection_count");

    //进入设置页面
    public void enterSettingPage(){
        click("我的柠檬页面-设置按钮",settingBy);
    }

    //获取收藏数量
    public Integer getCollectionCount(){
        String text = getElementText("我的柠檬页面-收藏数量",collectionCountBy);
        return Integer.valueOf(text);
    }

}
