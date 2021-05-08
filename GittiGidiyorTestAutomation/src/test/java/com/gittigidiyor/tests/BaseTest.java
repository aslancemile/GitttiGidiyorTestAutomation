package com.gittigidiyor.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	
    public static WebDriver driver;
    
    @BeforeClass
    public static void before(){
    	
    	System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
    	driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDown(){
 
        driver.quit();

    }
    
    
}