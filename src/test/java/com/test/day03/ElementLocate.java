package com.test.day03;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ElementLocate {              //Element元素 Locate定位

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
    desiredCapabilities.setCapability("noReset", "true");    //true不清除 false清除，不清除登录信息才能直接进入题库页面

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    Thread.sleep(4000);
   //元素定位
    //原则：通过该元素定位方式找到的元素必须是唯一
    //1.id定位--根据App元素的resource-id属性
    //driver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();
    //2.text定位
    // driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"题库\")")).click();
    //3.className定位 --根据App元素的class属性
    //WebElement webElement = driver.findElement(MobileBy.className("android.widget.FrameLayout"));
    //如果你通过findElement定位元素（你的定位表达式找到的元素有多个的情况下），那么findElement返回第一个元素
        /*List<WebElement> list = driver.findElements(MobileBy.className("android.widget.FrameLayout"));
        list.get(2).click();*/
    //4.accessbility id定位--根据App元素的content-desc属性
    //driver.findElement(MobileBy.AccessibilityId("题库")).click();

    //5.xpath定位,分为绝对定位和相对定位。绝对定位，一旦页面结构发生变化容易失效，因此通常我们使用相对路径
    //单属性选择
    //driver.findElement(MobileBy.xpath("//*[@content-desc='题库']")).click();
    //多属性选择
    // //*[@content-desc='题库' and @resource-id='com.lemon.lemonban:id/navigation_tiku']]
    //driver.findElement(MobileBy.xpath("//*[@content-desc='题库' and @resource-id='com.lemon.lemonban:id/navigation_tiku']")).click();

    driver.findElement(MobileBy.xpath("//*[@content-desc='题库']")).click();       //driver驱动 findElement寻找元素 MobileBy移动端定位方式
    Thread.sleep(3000);
    //xpath轴定位
    //轴名称
    //parent               选取当前节点的父节点
    //preceding-sibling      选取当前节点之前的所有兄弟节点
    //following-sibling       选取当前节点之后的所有兄弟节点
    //使用语法：   /轴名称::节点名称[@属性=值]
    //思路：1.先找到Java自动化 //*[@text='Java自动化']  2.再通过关系确认轴名称是哪个  3.通过轴定位找到对应目标元素
    //driver.findElement(MobileBy.xpath("//*[@text='Java自动化']/following-sibling::android.widget.TextView[2]")).click();     //这个下标从1开始
    //获取被定位的元素
    WebElement webElement = driver.findElement(MobileBy.xpath("//*[@text='Java自动化']/following-sibling::android.widget.TextView[2]"));
    System.out.println(webElement.getAttribute("text"));          //getAttribute获取属性

  }

  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    //关闭测试App
    driver.quit();
  }
}
