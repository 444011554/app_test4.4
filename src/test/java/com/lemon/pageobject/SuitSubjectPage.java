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
 * @Create: 2022-04-02 17:18
 * @Desc：
 **/

public class SuitSubjectPage extends BasePage {      //套题标题页
    By suitSubjectTitleBy = MobileBy.id("com.lemon.lemonban:id/suit_subject_title");

    public void randomClickSuitSubject(){
        List<WebElement> list = waitElementsVisible(suitSubjectTitleBy);
        Random random = new Random();
        int randomNum = random.nextInt(list.size());         //以int形式返回列表中元素的个数
        list.get(randomNum).click();        //获取随机值并点击
    }

}
