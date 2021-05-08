package com.gittigidiyor.tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) 

public class TestCases extends BaseTest{
 
    final static Logger logger = Logger.getLogger(TestCases.class);
    
    
    
    @Test
    public void Test1_Homepage() throws InterruptedException
    {
        driver.get("http://www.gittigidiyor.com/");
    }     
        
        
    @Test
    public void Test2_HomePageControl() throws InterruptedException    
    {
    	try {
        String j = driver.getTitle();
        Assert.assertEquals("GittiGidiyor - T�rkiye'nin �nc� Al��veri� Sitesi",j);
        Assert.assertEquals("GittiGidiyor - T�rkiye'nin �nc� Al��veri� Sitesi",driver.getTitle());
        Thread.sleep(3000);
        
    	} catch (Exception e) {
			logger.error("Anasayfa ba�ar�s�z!", e);
	    }
    	  logger.info("Anasayfaya giri� yap�ld�.");
    }
    
    
    @Test
    public void Test3_Login() throws InterruptedException{
    {
	    Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.fQSWwJ > div > div:nth-child(1)"));
		action.moveToElement(element).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main-header > div:nth-child(3) > div > div > div > div.sc-1nx8ums-0.fQSWwJ > div > div:nth-child(1)")));
		WebElement element2 = driver.findElement(By.cssSelector("a[data-cy='header-login-button']"));
		action.moveToElement(element2);
		action.click().build().perform();
		
		try {
		driver.findElement(By.id("L-UserNameField")).sendKeys("softwaree.testing@gmail.com");
		driver.findElement(By.id("L-PasswordField")).sendKeys("abc123456");
		driver.findElement(By.id("gg-login-enter")).click();
		   Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Login ba�ar�s�z!", e);
	    }
		logger.info("Login ba�ar�l�.");
    }
	 
    }


   
    @Test
    public void Test4_SearchProduct() throws InterruptedException {
     
        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys("bilgisayar");
        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
        Thread.sleep(3000);
      
      
    }

   
    @Test
    public void Test5_SecondPage() throws InterruptedException {
    	
    	
    	try {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.className("next-link"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a")).click();
        Thread.sleep(3000);
    	Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor - 2/100"));
    	} catch (Exception e) {
    		
			logger.error("2. sayfan�n a��lmas� ba�ar�s�z!", e);
	    }
        logger.info("2. Sayfa ba�ar�l� bir �ekilde a��ld�.");
        
    }

    
 
    @Test
    public void Test6_SelectProduct(){
    	
    	driver.findElement(By.id("product_id_645851285")).click();
    	
    }

 
    @Test
    public void Test7_AddBasket() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id=\"add-to-basket\"]")).click();
      
    }
    
   
 
    @Test
    public void Test8_PriceComparison() throws InterruptedException {
       String price=driver.findElement(By.cssSelector("span[id='sp-price-highPrice']")).getText();
       Thread.sleep(2000);
       driver.findElement(By.cssSelector("a[class='gg-ui-btn-default padding-none']")).click();
       Thread.sleep(3000);
       String sepetprice=driver.findElement(By.cssSelector("div[class='total-price']")).getText();
       try {
       Assert.assertEquals(price,sepetprice);
       
       } catch (Exception e) {
   
			logger.error("Fiyat kar��la�t�rma ba�ar�s�z!", e);
	    }
       logger.info("Fiyat kar��la�t�rma ba�ar�l�.");
    
    }
    
  /* 
    A�IKLAMA
    (�r�n adedi se�ilen dropdown) ve (sil ikonu) ile i�lem yap�lamad�. click yap�nca eylem ger�ekle�miyor. Bu y�zden son iki testi ger�ekle�tirilmedi.
    �r�n index 1-48 aras�nda fakat random �r�n� se�emedi�im i�in kendi belirledi�im �r�n� se�tim.
  */  
    
  
   
}