package com.test.day06;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: 86150
 * @Create: 2021-03-11 11:05
 * @Desc： 作业
 **/
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HybridTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //用来打开测试APP
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");
        //noReset参数--不清除掉App的数据
        //desiredCapabilities.setCapability("noReset", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        //在原生页面定位元素
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"柠檬社区\")")).click();
        Thread.sleep(3000);
        //要知道webview名字
        System.out.println(driver.getContextHandles());
        //NATIVE_APP:原生页面
        //WEBVIEW_com.lemon.lemonban:表示web页面
        //切换webview
        driver.context("WEBVIEW_com.lemon.lemonban");
        //进入到web模式并开始定位web页面元素
        driver.findElement(By.xpath("//span[contains(text(),'注册')]")).click();    //web页面用By.xpath;原生页面用MobileBy.xpath
        //点击登录
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        //输入用户名
        driver.findElement(By.id("nameOrEmail")).sendKeys("15029889124");
        //输入密码
        driver.findElement(By.id("userPassword")).sendKeys("889124");
        //点击登录
        driver.findElement(By.id("verifyLogin")).click();

        //切换至原生页面模式
        //driver.context("NATIVE_APP");




    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //关闭测试App
        driver.quit();
    }
}
