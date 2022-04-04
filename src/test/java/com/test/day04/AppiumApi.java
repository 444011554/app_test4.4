package com.test.day04;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-03-31 16:32
 * @Desc：
 **/

public class AppiumApi {
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
        WebElement webElement = driver.findElement(MobileBy.AccessibilityId("题库"));
        System.out.println(webElement.getAttribute("resourceId"));
        //currentActivity --获取当前页面名
        //System.out.println(driver.currentActivity());
        //getPageSource --获取当前页面源代码
        //System.out.println(driver.getPageSource());
        //获取设备时间信息
        /*System.out.println(driver.getDeviceTime());
        //获取设备DPI，注意不是分辨率
        System.out.println(driver.getDisplayDensity());
        //获取automation name，默认为null，如果有指定automation name为uiautomator2就为对应的值
        System.out.println(driver.getAutomationName());;
        //获取设备横竖屏状态，有PORTRAIT(竖屏)与LANDSCAPE(横屏)
        System.out.println(driver.getOrientation());*/

        //android按键事件操作
        //1.实例化keyEvent对象
        /*KeyEvent keyEvent = new KeyEvent();
        //2.按键事件对象携带对应的按键：back
        keyEvent.withKey(AndroidKey.BACK);
        //3.执行发送按键事件
        driver.pressKey(keyEvent);*/

        //截图
        //1.得到截图源文件对象
        /*File srcFile = driver.getScreenshotAs(OutputType.FILE);
        //2.生成本地文件的目标文件对象
        File dstFile = new File("E:\\screenshot\\111.png");
        try {
            //3.把截图源文件对象拷贝到目标文件对象中去-----把截图保存到本地（文件的形式）
            FileUtils.copyFile(srcFile,dstFile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //坐标点击  题库 454  1541      当findElement实在找不到元素的时候，可以使用坐标点击
        //1.得到TouchAction对象
        TouchAction touchAction = new TouchAction(driver);
        //2.通过touchAction提供的api----press
        //release()---手指抬起
        //perform()---让动作生效
        touchAction.press(PointOption.point(454,1541)).release().perform();
        //万不得已，不要用坐标点击，随屏幕大小改变


    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}



