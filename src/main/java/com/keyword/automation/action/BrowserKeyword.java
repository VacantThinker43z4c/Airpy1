package com.keyword.automation.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.keyword.automation.base.browser.BrowserType;
import com.keyword.automation.base.browser.Browsers;
import com.keyword.automation.base.common.Constants;
import com.keyword.automation.base.utils.LogUtils;

import java.net.URL;

/**
 * 封装浏览器操作关键字
 *
 * @author Amio_
 */
public class BrowserKeyword {
    // 不允许被初始化
    private BrowserKeyword() {

    }

    /**
     * 使用默认浏览器打开指定url
     *
     * @param requestUrl 请求url地址
     */
    public static void browserOpen(String requestUrl) {
        BrowserType bType = BrowserType.valueOf(Constants.DEFAULT_BROWSER);
        String reqUrl = verifyRequestUrl(requestUrl);
        Browsers.createDriver(bType).open(reqUrl);
    }

    /**
     * 根据传入浏览器类型打开指定url
     *
     * @param browserType 浏览器类型(Chrome/Firefox/IE/Opera/Safari)
     * @param requestUrl  请求url地址
     */
    public static void browserOpen(String browserType, String requestUrl) {
        BrowserType bType = verifyBrowserType(browserType);
        String reqUrl = verifyRequestUrl(requestUrl);
        Browsers.createDriver(bType).open(reqUrl);
    }

    /**
     * 获取当前打开标签页Url
     *
     * @return 当前打开标签页Url
     */
    public static String getCurrentUrl() {
        return Browsers.getActiveBrowser().getCurrentUrl();
    }

    /**
     * 获取当前打开标签页的title
     *
     * @return 当前打开标签页的title
     */
    public static String getCurrentTitle() {
        return Browsers.getActiveBrowser().getCurrentTitle();
    }

    /**
     * 获取当前打开标签页的源码
     *
     * @return 当前打开标签页的源码
     */
    public static String getPageSource() {
        return Browsers.getActiveBrowser().getPageSource();
    }

    /**
     * 关闭当前标签页
     */
    public static void browserClose() {
        Browsers.getActiveBrowser().browserClose();
    }

    /**
     * 退出浏览器，关闭所有标签页
     */
    public static void browserQuit() {
        Browsers.getActiveBrowser().browserQuit();
    }

    /**
     * 当打开新标签页时，切换到新窗口
     */
    public static void switchToWindow() {
        Browsers.getActiveBrowser().switchToWindow();
    }

    /**
     * 当存在多标签页时，切换到指定窗口
     *
     * @param windowTitle 指定窗口的Title
     */
    public static void switchToWindow(String windowTitle) {
        Browsers.getActiveBrowser().switchToWindow(windowTitle);
    }

    /**
     * 切换到当前页面顶级frame或者window
     */
    public static void switchToDefaultFrameOrWindow() {
        Browsers.getActiveBrowser().switchToDefaultFrame();
    }

    /**
     * 根据frame的索引切换
     *
     * @param index frame索引
     */
    public static void switchToFrame(int index) {
        Browsers.getActiveBrowser().switchToFrame(index);
    }

    /**
     * 根据frame的id或name切换
     *
     * @param obj frame的id或name
     */
    public static void switchToFrame(Object obj) {
        Browsers.getActiveBrowser().switchToFrame(obj);
    }

    /**
     * 根据元素定位方式切换
     *
     * @param by 元素定位方式By(By.id(xx)/By.name(xx)等)
     */
    public static void switchToFrame(By by) {
        Browsers.getActiveBrowser().switchToFrame(by);
    }

    /**
     * 切换到父frame
     */
    public static void switchToParentFrame() {
        Browsers.getActiveBrowser().switchToParentFrame();
    }

    /**
     * 通过页面元素切换frame
     *
     * @param locator      元素定位类型(id/name/linkText/partialLinkText/tagName/xpath/
     *                     className/cssSelector)
     * @param locatorValue 元素定位值
     */
    public static void switchToFrame(String locator, String locatorValue) {
        Browsers.getActiveBrowser().switchToFrame(locator, locatorValue);
    }

    /**
     * 通过页面元素切换frame
     *
     * @param webElement
     */
    public static void switchToFrame(WebElement webElement) {
        Browsers.getActiveBrowser().switchToFrame(webElement);
    }

    /**
     * 浏览器后退导航
     */
    public static void browserBack() {
        Browsers.getActiveBrowser().browserBack();
    }

    /**
     * 浏览器前进导航
     */
    public static void browserForward() {
        Browsers.getActiveBrowser().browserForward();
    }

    /**
     * 浏览器到指定URL导航
     *
     * @param requestUrl 指定URL
     */
    public static void BrowserTo(String requestUrl) {
        Browsers.getActiveBrowser().BrowserTo(requestUrl);
    }

    /**
     * 浏览器到指定URL导航
     *
     * @param requestUrl 指定URL
     */
    public static void BrowserTo(URL requestUrl) {
        Browsers.getActiveBrowser().BrowserTo(requestUrl);
    }

    /**
     * 浏览器刷新
     */
    public static void browserRefresh() {
        Browsers.getActiveBrowser().browserRefresh();
    }

    /**
     * 最大化浏览器
     */
    public static void browserMax() {
        Browsers.getActiveBrowser().browserMax();
    }

    /**
     * 验证传入浏览器类型
     *
     * @param browserType 浏览器类型
     * @return 浏览器类型
     */
    private static BrowserType verifyBrowserType(String browserType) {
        BrowserType bType;
        if (browserType.equalsIgnoreCase("Chrome")) {
            bType = BrowserType.Chrome;
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            bType = BrowserType.Firefox;
        } else if (browserType.equalsIgnoreCase("IE")) {
            bType = BrowserType.IE;
        } else if (browserType.equalsIgnoreCase("Opera")) {
            bType = BrowserType.Opera;
        } else if (browserType.equalsIgnoreCase("Safari")) {
            bType = BrowserType.Safari;
        } else {
            bType = BrowserType.valueOf(Constants.DEFAULT_BROWSER);
            LogUtils.warn("您输入的浏览器类型错误，已经初始化Chrome浏览器.");
        }
        return bType;
    }

    /**
     * 格式化请求URL
     *
     * @param requestUrl 请求的url
     * @return 格式化后的请求url
     */
    private static String verifyRequestUrl(String requestUrl) {
        String reqUrl;
        if (requestUrl.toLowerCase().startsWith("http://") || requestUrl.toLowerCase().startsWith("https://")) {
            reqUrl = requestUrl;
        } else {
            reqUrl = "http://" + requestUrl;
        }
        return reqUrl;
    }
}
