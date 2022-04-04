package com.lemon.testcases;

import com.lemon.base.BaseTest;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.pageobject.MyLemonPage;
import com.lemon.pageobject.SettingPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-01 19:39
 * @Desc：
 **/

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setup() throws MalformedURLException {        //throws MalformedURLException抛出异常
        //用例前置：准备工作
        //1.打开测试APP----优化：取消了该步骤，把打开APP放到BaseTest中的BeforeTest里面了
        //创建一个新的对象indexPage
        IndexPage indexPage = new IndexPage();
        //2.进入到APP登录页面
        indexPage.enterLoginPage();
    }

    @Test
    public void testLoginSuccess(){
        //测试主体
        //创建一个新的对象loginPage
        LoginPage loginPage = new LoginPage();
        //分别输入手机号码、密码，并点击登录按钮
        loginPage.login("15029889124","889124");
        //断言
        //断言一：根据用户名
        //创建一个新的对象indexPage
        IndexPage indexPage = new IndexPage();
        //获取实际用户名
        String userNameActual = indexPage.getUserNameText();
        //期望用户名
        String userNameExpected = "夏冬波";
        //实际值与期望值做断言比较
        Assert.assertEquals(userNameActual,userNameExpected);
        //断言二：根据跳转之后（登录成功）界面名
        //.activity.MainActivity -->我们期望的界面名---通过命令adb shell dumpsys activity | find "mResumedActivity"所得出
        String expectedValue = ".activity.MainActivity";
        //获取当前正在前台运行的界面名
        String actualValue = driver.currentActivity();       // currentActivity()当前正在前台运行的界面名
        //实际值与期望值做断言比较
        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test(dataProvider = "getLoginFailureDatas")
    public void testLoginFailure(String mobilephone, String pwd, String toastTips){
        //创建一个新的对象loginPage
        LoginPage loginPage = new LoginPage();
        //分别输入手机号码、密码，并点击登录按钮
        loginPage.login(mobilephone,pwd);
        //断言
        //根据toast弹窗文本
        //获取实际toast文本
        String actual = getToastText(toastTips);
        //期望toast文本
        String expected = toastTips;
        //断言
        Assert.assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] getLoginFailureDatas(){
        //数据源-数据驱动源数据保存的地方
        //数据驱动使用前提：操作流程一样、断言方式一样
        Object[][] datas = {{"","889124","手机号码或密码不能为空"},
                {"15029889124","","手机号码或密码不能为空"},
                {"1502988912%","889124","手机号码格式不正确"},
                {"1502988912","889124","手机号码格式不正确"}};
        //不管是读取文件/数据库，最终都要转换为Object[][]
        return datas;
    };

    @AfterClass
    public void tearDown(){
        //用例后置：用例善后工作
        //退出登录
        MyLemonPage myLemonPage = new MyLemonPage();
        myLemonPage.enterSettingPage();          //从我的柠檬页面进入设置页面
        SettingPage settingPage = new SettingPage();
        settingPage.quitLogin();         //从设置页面进行退出操作
    }

}
