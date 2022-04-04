package com.lemon.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-01 20:25
 * @Desc：
 **/

public class BaseTest extends BasePage {

    public static AndroidDriver driver;    //driver静态全局共享

    @BeforeTest
    //参数化，将下列5个参数放到testng.xml文件里面
    @Parameters({"deviceName","platformName","appPackage","appActivity","appiumUrl"})
    public void setUpTest(String deviceName,String platformName,String appPackage,
                          String appActivity,String appiumUrl){
        //打开测试APP
        //desired Capabilities预期功能
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        //URL地址是Appium服务的地址（接口地址）
        //remoteUrl远程的URL地址
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(appiumUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);     //driver实例化
        //manage管理   timeouts超时    implicitly隐式的    TimeUnit时间单位
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);        //隐式等待5,秒

    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();                 //退出APP
    }



    /**
     * 发送按键事件二次封装
     * @param androidKey
     */
    public void pressKeycode(AndroidKey androidKey){
        //1.实例化keyEvent对象 ----按键事件
        KeyEvent keyEvent = new KeyEvent();
        //2.按键事件对象携带对应的按键： back----返回键功能
        keyEvent.withKey(androidKey);
        //3.执行发送按键事件
        driver.pressKey(keyEvent);

    }
}
