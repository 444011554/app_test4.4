package com.test.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SpecialElement_zs {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    //用来打开测试APP
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appPackage", "cmb.pb");
    desiredCapabilities.setCapability("appActivity", "cmb.pb.app.mainframe.container.PBMainActivity");
    //noReset参数--不清除掉App的数据
    //desiredCapabilities.setCapability("noReset", "true");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    //1.点击跳过
    driver.findElement(MobileBy.id("cmb.pb:id/btn_skip")).click();
    //2.点击同意
    driver.findElement(MobileBy.id("cmb.pb:id/btn_launch_privacy_agree")).click();
    //3.点击允许
    driver.findElement(MobileBy.id("cmb.pb:id/button_positive")).click();
    //4.点击关闭广告
    driver.findElement(MobileBy.id("cmb.pb:id/ivCancle")).click();
    //5.点击转账，进入登录页面
    driver.findElement(MobileBy.id("cmb.pb:id/ivFuncIcon")).click();
    //6.输入账号
    driver.findElement(MobileBy.id("cmb.pb:id/edAccountNo")).sendKeys("15029889124");
    //7.点击已同意
    driver.findElement(MobileBy.id("cmb.pb:id/ivAgreementSelected")).click();
    //8.点击注册/登录
    driver.findElement(MobileBy.id("cmb.pb:id/tvLoginButtonText")).click();





  }


  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    //关闭测试App
    driver.quit();
  }
}
