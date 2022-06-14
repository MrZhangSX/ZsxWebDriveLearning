package com.zsx.webdrive.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriveDemo1 {
    public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.edge.driver", "E:\\zsx\\msedgedriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.get("http://www.baidu.com");
            Dimension size = new Dimension(2560, 1440);
            driver.manage().window().maximize();
            TestName(driver);
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

