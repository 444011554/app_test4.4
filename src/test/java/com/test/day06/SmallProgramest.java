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
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SmallProgramest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        //用来打开测试APP
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
        desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");

        //noReset参数--不清除掉App的数据
        //！!!!一定要注意，加这个配置，不然微信的所有数据就没有了
        desiredCapabilities.setCapability("noReset", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        //

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //关闭测试App
        driver.quit();
    }
}
