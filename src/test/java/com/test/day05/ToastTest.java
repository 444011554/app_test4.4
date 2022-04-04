package com.test.day05;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ToastTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //用来打开测试APP
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
        desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      //隐式等待
    }

    @Test
    public void sampleTest() throws InterruptedException {
        Thread.sleep(4000);
        //进入登录页面
        MobileElement el4 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"我的柠檬\"]/android.widget.ImageView");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");
        el5.click();
        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
        el6.sendKeys("15029889124");
        MobileElement el7 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
        el7.sendKeys("889123");      //填写错误密码
        MobileElement el8 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
        el8.click();

        //显示等待
        //注意：如果是显示等待定位toast元素，条件只有一个---等待元素存在
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        //WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[contains(@text,'错误的账号')]")));

        WebElement webElement = waitElementPresence(MobileBy.xpath("//*[contains(@text,'错误的账号')]"));

        //获取toast
        //获取方式 driver.findElement(MobileBy.xpath("//*[contains(@text,'tips')]"));       contains:包含
        //WebElement webElement = driver.findElement(MobileBy.xpath("//*[contains(@text,'错误的账号')]"));    //错误的账号，模糊查询，可以只写一部分
        System.out.println(webElement.getText());

    }

    /**
     * 等待元素存在-使用显式等待
     * @param by  元素定位信息
     * @return
     */
    public WebElement waitElementPresence(By by) {           //waitElementPresence等待元素存在
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webElement;
    }



    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //关闭测试App
        driver.quit();
    }
}
