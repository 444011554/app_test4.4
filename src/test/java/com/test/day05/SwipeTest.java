package com.test.day05;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwipeTest {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    //用来打开测试APP
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appPackage", "com.xxzb.fenwoo");
    desiredCapabilities.setCapability("appActivity", "com.xxzb.fenwoo.activity.addition.WelcomeActivity");
    //noReset参数--不清除掉App的数据
    //desiredCapabilities.setCapability("noReset", "true");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    Thread.sleep(4000);
    swipe_version1();
    swipe_version2();
    swipe_version3();

  }

  public void swipe_version1(){
    //滑动操作-TouchAction
    TouchAction touchAction = new TouchAction(driver);
    //滑动起始点X轴（获取屏幕宽度）
    int width = driver.manage().window().getSize().getWidth();
    //滑动起始点Y轴（获取屏幕高度）
    int height = driver.manage().window().getSize().getHeight();
    //把坐标转换为PointOption类型（press这个方法需要该类型的参数）
    //滑动起始点
    PointOption pointOptionA = PointOption.point(width*3/4,height/2);
    //滑动终点
    PointOption pointOptionB = PointOption.point(width/4,height/2);
    //把滑动时间转换为waitoptions类型
    Duration duration = Duration.ofMillis(600);
    WaitOptions waitOptions = WaitOptions.waitOptions(duration);
    //滑动操作链路--手指按下滑动起始点->滑动到终点->手指抬起
    //press---按下    waitAction---等待时间    moveTo---移动    release---让手指释放掉     perform---让动作生效
    touchAction.press(pointOptionA).waitAction(waitOptions).moveTo(pointOptionB).release().perform();

  }
  public void swipe_version2(){
    //滑动操作-TouchAction
    TouchAction touchAction = new TouchAction(driver);
    //滑动起始点X轴（获取屏幕宽度）
    int width = driver.manage().window().getSize().getWidth();
    //滑动起始点Y轴（获取屏幕高度）
    int height = driver.manage().window().getSize().getHeight();
    //把坐标转换为PointOption类型（press这个方法需要该类型的参数）
    //滑动起始点
    PointOption pointOptionA = PointOption.point(width*3/4,height/2);
    //滑动终点
    PointOption pointOptionB = PointOption.point(width/4,height/2);
    //把滑动时间转换为waitoptions类型
    Duration duration = Duration.ofMillis(400);
    WaitOptions waitOptions = WaitOptions.waitOptions(duration);
    //滑动操作链路--手指按下滑动起始点->滑动到终点->手指抬起
    touchAction.press(pointOptionA).waitAction(waitOptions).moveTo(pointOptionB).release().perform();

  }
  public void swipe_version3(){
    //滑动操作-TouchAction
    TouchAction touchAction = new TouchAction(driver);
    //滑动起始点X轴（获取屏幕宽度）
    int width = driver.manage().window().getSize().getWidth();
    //滑动起始点Y轴（获取屏幕高度）
    int height = driver.manage().window().getSize().getHeight();
    //把坐标转换为PointOption类型（press这个方法需要该类型的参数）
    //滑动起始点
    PointOption pointOptionA = PointOption.point(width*3/4,height/2);
    //滑动终点
    PointOption pointOptionB = PointOption.point(width/4,height/2);
    //把滑动时间转换为waitoptions类型
    Duration duration = Duration.ofMillis(400);
    WaitOptions waitOptions = WaitOptions.waitOptions(duration);
    //滑动操作链路--手指按下滑动起始点->滑动到终点->手指抬起
    touchAction.press(pointOptionA).waitAction(waitOptions).moveTo(pointOptionB).release().perform();

  }

  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    //关闭测试App
    driver.quit();
  }
}
