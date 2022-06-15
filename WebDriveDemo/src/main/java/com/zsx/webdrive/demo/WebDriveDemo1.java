package com.zsx.webdrive.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriveDemo1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "E:\\zsx\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        //driver.get("http://www.baidu.com");
        driver.get("https://www.douyu.com/topic/202205_DOTA2?rid=9999");
        Dimension size = new Dimension(2560, 1440);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        //javascriptExecutor.executeScript("document.body.style.zoom='1.7'");
        //顶部
        //javascriptExecutor.executeScript("document.documentElement.scrollTop=0");
        //底部
        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        System.out.println("Title is " + driver.getTitle());
        System.out.println("url is " + driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.quit();
        }
    public static void TestId(WebDriver driver){

    }

    public static void TestName(WebDriver driver){
        WebElement element = driver.findElement(By.linkText("地图"));
        element.click();
    }

    public static void TestXpath(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[3]"));
        element.click();
    }
}

