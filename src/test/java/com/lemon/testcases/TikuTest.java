package com.lemon.testcases;

import com.lemon.base.BaseTest;
import com.lemon.pageobject.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-02 18:23
 * @Desc：
 **/

public class TikuTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        //进入到登录页面
        IndexPage indexPage = new IndexPage();
        indexPage.enterLoginPage();
        //直接登录
        LoginPage loginPage = new LoginPage();
        loginPage.login("15029889124","889124");
    }

    @Test
    public void testTikuAnswer(){
        //进入到题库里面
        IndexPage indexPage = new IndexPage();
        indexPage.enterTikuPage();
        //随机选择标题
        TikuPage tikuPage = new TikuPage();
        tikuPage.randomClickList();
        //随机选择难度级别
        DiffcultLevelPage diffcultLevelPage = new DiffcultLevelPage();
        diffcultLevelPage.randomClickLevel();
        //随机选择套题
        SuitSubjectPage suitSubjectPage = new SuitSubjectPage();
        suitSubjectPage.randomClickSuitSubject();
        //点击答案开关
        SubjectViewPage subjectViewPage = new SubjectViewPage();
        subjectViewPage.clickAnswerSwitch();
        //断言
        Assert.assertTrue(subjectViewPage.isAnswerViewisible());     //注意此处用assertTrue

    }

    @Test
    public void testTikuFavourite() throws InterruptedException {       //测试题库收藏功能
        //返回到上一级页面
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);

        //进入我的柠檬
        IndexPage indexPage = new IndexPage();
        indexPage.enterMyLemonPage();
        //获取期望收藏记录数量
        MyLemonPage myLemonPage = new MyLemonPage();
        int expectedCount = myLemonPage.getCollectionCount()+1;
        //进入到题库页面
        indexPage.enterTikuPage();
        //随机选择标题
        TikuPage tikuPage = new TikuPage();
        tikuPage.randomClickList();
        //随机点击难度级别
        DiffcultLevelPage diffcultLevelPage = new DiffcultLevelPage();
        diffcultLevelPage.randomClickLevel();
        //随机点击套题标题
        SuitSubjectPage suitSubjectPage = new SuitSubjectPage();
        suitSubjectPage.randomClickSuitSubject();
        //点击收藏按钮
        SubjectViewPage subjectViewPage = new SubjectViewPage();
        subjectViewPage.clickFavourite();
        //断言1-根据toast信息：收藏成功
        String actual = getToastText("收藏成功");
        Assert.assertEquals(actual,"收藏成功");
        //返回到上一级页面
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);
        Thread.sleep(500);
        pressKeycode(AndroidKey.BACK);
        //进入我的柠檬页面
        indexPage.enterMyLemonPage();
        //断言2-根据收藏记录数量+1
        //获取当前实际值
        int actualCount = myLemonPage.getCollectionCount();
        //与上述期望值对比
        Assert.assertEquals(actualCount,expectedCount);

    }

    @AfterClass
    public void tearDown(){
        //用例后置：用例善后工作
        //driver.quit();
    }


}
