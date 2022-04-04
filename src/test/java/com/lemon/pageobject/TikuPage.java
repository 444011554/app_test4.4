package com.lemon.pageobject;

import com.lemon.base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-02 17:29
 * @Desc：
 **/

public class TikuPage extends BasePage {                //题库页面
    //1.列表页标题元素
    By titleBy = MobileBy.id("com.lemon.lemonban:id/fragment_category_type");

    /**
     * 随机点击题库列表标题
     * @param driver
     */
    public void randomClickList(){
        //存放所有列表标题元素
        List<WebElement> list = waitElementsVisible(titleBy);
        //随机选择列表中某个标题元素去点击
        Random random = new Random();
        int randomNum = random.nextInt(list.size());       //以int形式返回列表中元素的个数
        list.get(randomNum).click();        //获取随机值并点击
    }

}
