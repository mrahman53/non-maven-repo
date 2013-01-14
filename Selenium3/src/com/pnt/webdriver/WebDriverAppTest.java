package com.pnt.webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WebDriverAppTest {
	
  public WebDriver driver = null; 	
  
  @BeforeMethod
  public void beforeMethod() {
	  driver= new FirefoxDriver();
	  //driver = new SafariDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.cnn.com");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void f() throws InterruptedException {
	  //driver.switchTo().alert().dismiss();
	  driver.findElement(By.xpath(".//*[@id='nav-us']/span")).click();
	  System.out.println("URL : " + driver.getCurrentUrl());
	  System.out.println("Title : " +  driver.getTitle());
	  //System.out.println("Page Source : " + driver.getPageSource());
	  //WebDriver way to compare text.
	 // driver.findElement(By.xpath(".//*[@id='cnn_mtt1rgtarea']/ul/li[8]/a")).getText().compareTo("Arizona Powerball winner claims nearly $200 million prize");
	 //Using TestNG method to verify text.
	  //Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='cnn_mtt1rgtarea']/ul/li[8]/a")).getText(), "Arizona Powerball winner claims nearly $200 million prize");
	  for(int i=0; i<5; i++){
	  driver.findElement(By.id("hdr-search-box")).clear();  
	  driver.findElement(By.id("hdr-search-box")).sendKeys(randomSearch());
	  driver.findElement(By.cssSelector(".ftr-search-sicon>input")).click();
	  driver.findElement(By.id("txtTopSearch")).clear();
	  driver.findElement(By.id("txtTopSearch")).sendKeys(randomSearch());
	  driver.findElement(By.className("searchButton")).click();
      Thread.sleep(3000);
      System.out.println("Current URL : " +driver.getCurrentUrl());
      System.out.println("Current Title : " +  driver.getTitle());
      driver.navigate().back();
      driver.navigate().back();
     
	  } 
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
	  
  }
  
public String randomSearch(){
	  
	  String[] words = new String[11];
		words[0]="politics";
		words[1]="Gop";
		words[2]="Democrate";
		words[3]="Money";
		words[4]="like this topics";
		words[5]="Africa";
		words[6]="sharing with my friends";
		words[7]="Obama";
		words[8]="Europe";
		words[9]="world";
		words[10]="Asia";
		String search = "";
		Random random = new Random();
		int randomWords = random.nextInt(10)+1;
		for(int index=0; index<1; index++){
			
		    search = words[randomWords];
			randomWords = random.nextInt(10)+1;
		}
		return search;
  }

}
