package com.lemon.pageobject;

import com.lemon.base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-02 15:43
 * @Desc：
 **/

public class DiffcultLevelPage extends BasePage {                //难度级别页面
    By firstLevel = MobileBy.id("com.lemon.lemonban:id/first_level");
    By secondLevel = MobileBy.id("com.lemon.lemonban:id/second_level");
    By thirdLevel = MobileBy.id("com.lemon.lemonban:id/third_level");

    public void randomClickLevel(){
        //1.把三个元素保存到集合中
        List<By> list = new ArrayList<By>();
        list.add(firstLevel);
        list.add(secondLevel);
        list.add(thirdLevel);
        //2.通过生成随机数0-2
        Random random = new Random();
        //获取随机数量
        int randomNum = random.nextInt(list.size());           //nextInt整形      //以int形式返回列表中元素的个数
        click("难度级别页面-等级按钮",list.get(randomNum));        //点击获取的随机按钮
    }
}
