package com.test.day04;

import io.appium.java_client.MobileBy;
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
import java.util.concurrent.TimeUnit;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-03-31 16:32
 * @Desc：
 **/

public class ElementWait {
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
        //一般设置隐式等待是在driver实例化之后
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //5秒
        //隐式等待针对全局的定位，且只有findElement才会有隐式等待的效果
    }

    @Test
    public void sampleTest() throws InterruptedException {
        driver.findElement(MobileBy.xpath("//*[@content-desc='题库']")).click();
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/button_go_login")).click();
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_mobile")).sendKeys("15029889124");
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/et_password")).sendKeys("889124");
        driver.findElement(MobileBy.id("com.lemon.lemonban:id/btn_login")).click();

        //显示等待
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        //until----直到某个条件满足时为止
        //ExpectedConditions----期望条件
        //elementToBeClickable----期望条件之一（可被点击） visibilityOfElementLocated(元素可见) presenceOfElementLocated（元素存在）
        //元素存在>元素可见>元素可被点击
        By by = MobileBy.xpath("//*[@content-desc='题库']");
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        webElement.click();

        //隐式等待 VS 显式等待
        //1.作用域范围：全局                   针对当前元素
        //2.等待条件：只有等待元素存在          等待元素存在、可见、可被点击
        //3.超时异常：NoSuchElementExcption    TimeoutExpected

    }

    /**
     * 等待元素可见-使用显式等待
     * @param by  元素定位信息
     * @return
     */
    public WebElement waitElementVisible(By by) {           //waitElementVisible等待元素可见
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webElement;
    }

    /**
     * 等待元素可被点击-使用显式等待
     * @param by  元素定位信息
     * @return
     */
    public WebElement waitElementClickable(By by) {           //waitElementClickable等待元素可被点击
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return webElement;
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
        driver.quit();
    }
}



