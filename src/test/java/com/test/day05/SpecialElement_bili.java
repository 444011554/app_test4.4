package com.test.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SpecialElement_bili {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    //用来打开测试APP
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appPackage", "tv.danmaku.bili");
    desiredCapabilities.setCapability("appActivity", "tv.danmaku.bili.MainActivityV2");
    //noReset参数--不清除掉App的数据
    //desiredCapabilities.setCapability("noReset", "true");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    //1.点击同意并继续
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/agree")).click();
    //2.关闭应用
    driver.findElement(MobileBy.id("android:id/aerr_close")).click();
    //3.再次打开哔哩哔哩APP----text定位
    driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"哔哩哔哩\")")).click();
    //4.我知道了
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/button")).click();
    //5.X掉
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/close")).click();
    //6.点击登录按钮
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/avatar_layout")).click();
    //硬性等待3秒，然后获取该页面源代码
//    Thread.sleep(3000);
//    System.out.println(driver.getPageSource());
    //7.点击密码登录
    driver.findElement(MobileBy.id("android:id/button1")).click();
    //硬性等待3秒，然后获取该页面源代码
//    Thread.sleep(3000);
//    System.out.println(driver.getPageSource());
    //8.请输入手机号码或邮箱
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/username")).sendKeys("15029889124");
    //9.请输入密码
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/userpwd")).sendKeys("xdb369");
    //10.坐标点击  我已阅读并同意 37  715
    TouchAction touchAction = new TouchAction(driver);
    touchAction.press(PointOption.point(37,715)).release().perform();
    //11.点击登录按钮
    driver.findElement(MobileBy.id("tv.danmaku.bili:id/btn_login")).click();



  }


  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    //关闭测试App
    driver.quit();
  }
}
