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
 * @Create: 2022-04-02 17:01
 * @Desc：
 **/

public class SubjectViewPage extends BasePage {               //主题视图页面
    //答案显示开关
    By answerSwitchBy = MobileBy.id("com.lemon.lemonban:id/switch_button");
    //答案显示区域
    By answerViewBy = MobileBy.id("com.lemon.lemonban:id/viewPagerAnswer");
    //收藏按钮
    By favouriteButtonBy = MobileBy.id("com.lemon.lemonban:id/action_favourite");

    //点击答案显示开关
    public void clickAnswerSwitch(){
        click("题目展示页面-答案开关",answerSwitchBy);
    }

    //答案是否可见
    public boolean isAnswerViewisible(){
        return isElementVisible("题目展示页面-答案展示",answerViewBy);      //答案显示区域是否可见
    }

    //点击收藏按钮
    public void clickFavourite(){
        click("题目展示页面-收藏",favouriteButtonBy);
    }

}
