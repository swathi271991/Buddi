package com.Cucumber.Learning.SIKULIIII;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;


public class XYZpractice {

	WebDriver driver;
	
	//when uploading files through SIKULI change display resolution of laptop to 1280*720

	@Test
	public void test() throws FindFailed, InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "F:\\SDET_COMPLETE_AUTOMATION\\HYBRID_SDET_PRACTICE\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//span[@class ='btn btn-success fileinput-button']")).click();
		
		Thread.sleep(3000);
		
		Pattern filetext = new Pattern("F:\\SikuliFiles\\Scrn1.PNG");
		Pattern openBtn = new Pattern("F:\\SikuliFiles\\scrn2.PNG");
		
		Screen s = new Screen();
		
		s.wait(filetext, 20);
		s.type(filetext, "F:\\SikuliFiles\\Fruites\\PineApple.jpg");
		s.click(openBtn);
		
		Thread.sleep(3000);
		
		WebElement startupload = driver.findElement(By.xpath("//button[@type ='submit']/span"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(startupload).click().build().perform();
		
		driver.findElement(By.xpath("(//i[@class ='glyphicon glyphicon-trash'])[2]")).click();
		
	}

}
