package com.test.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
//作业：柠檬班App
//尽可能在每一个页面都练习元素表达式：
//要求：
//1、把所有可见的元素用表达式写出来（推荐优先用Xpath）
//2、#页面名称 #题库 xpath表达式

public class ElementLocate_homework {

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
    desiredCapabilities.setCapability("noReset", "true");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    Thread.sleep(4000);
    //#主页#就业信息#高薪等你来拿
    driver.findElement(MobileBy.xpath("//*[@content-desc='主页']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='高薪等你来拿']")).click();
    //#主页#柠檬社区
    driver.findElement(MobileBy.xpath("//*[@content-desc='主页']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='柠檬社区']")).click();
    //#主页#视频教程
    driver.findElement(MobileBy.xpath("//*[@content-desc='主页']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='视频教程']")).click();
    //#题库#Linux#概述
    driver.findElement(MobileBy.xpath("//*[@content-desc='题库']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='Linux']/following-sibling::android.widget.TextView[1]")).click();
    //#题库#Linux#概述#初级
    driver.findElement(MobileBy.xpath("//*[@content-desc='题库']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='Linux']/following-sibling::android.widget.TextView[1]")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='初级']")).click();
    //#我的柠檬#本周课表#去请假
    driver.findElement(MobileBy.xpath("//*[@content-desc='我的柠檬']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='本周课表']")).click();
    Thread.sleep(2000);
    driver.findElement(MobileBy.xpath("//*[@text='去请假']")).click();





  }

  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    //关闭测试App
    driver.quit();
  }
}
