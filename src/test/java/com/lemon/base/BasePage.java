package com.lemon.base;

import com.lemon.pageobject.LoginPage;
import io.appium.java_client.MobileBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @Project: java26_app
 * @Site: http://www.lemonban.com
 * @Forum: http://testingpai.com
 * @Copyright: ©2020 版权所有 湖南省零檬信息技术有限公司
 * @Author: odin
 * @Create: 2022-04-03 19:42
 * @Desc：
 **/

public class BasePage {

    //实例化log4j日志对象
    Logger logger = Logger.getLogger(LoginPage.class);

    /**
     * 等待元素可见-使用显式等待
     * @param by
     * @return
     */
    public WebElement waitElementVisible(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(BaseTest.driver,5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));     //until直到
        return webElement;
    }

    /**
     * 等待多个元素可见-使用显式等待
     * @param by 元素定位信息
     * @return
     */
    public List<WebElement> waitElementsVisible(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(BaseTest.driver,5);
        List<WebElement> list = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return list;
    }

    /**
     * 等待元素可被点击-使用显式等待
     * @param by  元素定位信息
     * @return
     */
    public WebElement waitElementClickable(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(BaseTest.driver,5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return webElement;
    }

    /**
     * 等待元素存在-使用显式等待
     * @param by  元素定位信息
     * @return
     */
    public WebElement waitElementPresence(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(BaseTest.driver, 5);
        WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webElement;
    }



    /**
     * 输入操作二次封装
     * @param elementInfo 元素信息
     * @param by 元素定位信息
     * @param data 输入的数据
     */
    public void type(String elementInfo, By by, String data) {
        //BaseTest.driver.findElement(by).sendKeys(data);
        try {
            waitElementVisible(by).sendKeys(data);         //等待元素可见
            logger.info("往元素【"+ elementInfo +"】输入数据【"+ data +"】");
        } catch (Exception e) {                //exception异常
            logger.error("============自动化脚本执行异常，异常信息如下=============");
            logger.error(e);
        }

    }

    /**
     * 点击操作的二次封装
     * @param elementInfo 元素信息
     * @param by 元素定位
     */
    public void click(String elementInfo, By by) {
        //BaseTest.driver.findElement(by).click();
        try {
            waitElementClickable(by).click();
            logger.info("点击元素【"+ elementInfo +"】");
        } catch (Exception e) {
            logger.error("============自动化脚本执行异常，异常信息如下=============");
            logger.error(e);
        }
    }

    /**
     * 获取元素文本操作的二次封装
     * @param elementInfo
     * @param by 元素定位信息
     * @return
     */
    public String getElementText(String elementInfo, By by) {
        //return BaseTest.driver.findElement(by).getText();
        String text = null;
        try {
            text = waitElementPresence(by).getText();
            logger.info("获取元素【"+ elementInfo +"】的文本值【+ text +】");
            return waitElementPresence(by).getText();
        } catch (Exception e) {
            logger.error("============自动化脚本执行异常，异常信息如下=============");
            logger.error(e);
        }
        return text;          //return返回方法指定类型的值（这个值总是确定的）
    }

    /**
     * 判断元素是否可见
     * @param elementInfo
     * @param by 元素定位信息
     * @return
     */
    public boolean isElementVisible(String elementInfo, By by) {
        boolean isVisible = false;
        try {
            isVisible = waitElementVisible(by).isDisplayed();
            logger.info("判断元素【"+ elementInfo +"】是否可见：【"+ isVisible +"】");
        } catch (Exception e) {
            logger.error("============自动化脚本执行异常，异常信息如下=============");
            logger.error(e);
        }
        return isVisible;
    }

    /**
     * 获取toast元素文本的公共方法
     * @param partialToastText 部分toast文本
     * @return
     */
    public String getToastText(String partialToastText){
        //return driver.findElement(MobileBy.xpath("//*[contains(@text,'"+partialToastText+"')]")).getText();
        //toast元素获取：只能使用等待元素存在       contains包含
        String text = waitElementPresence(MobileBy.xpath("//*[contains(@text,'"+partialToastText+"')]")).getText();
        logger.info("获取toast文本【"+ text +"】");
        return text;

    }


}
