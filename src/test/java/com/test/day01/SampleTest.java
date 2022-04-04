package com.test.day01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
    desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() throws InterruptedException {
    Thread.sleep(4000);
    MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"我的柠檬\"]/android.widget.ImageView");
    el4.click();
    MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");
    el5.click();
    Thread.sleep(1000);
    MobileElement el6 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
    el6.sendKeys("15029889124");
    MobileElement el7 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
    el7.sendKeys("889124");
    MobileElement el8 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
    el8.click();
  }

  @AfterTest
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);
    driver.quit();
  }
}
