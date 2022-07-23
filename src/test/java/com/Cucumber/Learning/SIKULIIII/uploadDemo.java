package com.Cucumber.Learning.SIKULIIII;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class uploadDemo {

	WebDriver driver;
	WebDriverWait wait;
	
	//when uploading files through SIKULI change display resolution of laptop to 1280*720

	@Test
	public void test() throws InterruptedException, FindFailed
	{
		System.setProperty("webdriver.chrome.driver", "F:\\SDET_COMPLETE_AUTOMATION\\HYBRID_SDET_PRACTICE\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));


		driver.get("http://demo.automationtesting.in/Register.html");

		WebElement btn = driver.findElement(By.xpath("//*[@id='imagesrc']"));

		Actions builder = new Actions(driver);
		builder.moveToElement(btn).click().build().perform();
		
		Screen s = new Screen();

		Pattern fileInputTextBox = new Pattern("F:\\SikuliFiles\\FileTextBox.PNG");
		Pattern openButton = new Pattern("F:\\SikuliFiles\\OpenButton.PNG");

		Thread.sleep(5000);

		s.wait(fileInputTextBox, 20);
		s.type(fileInputTextBox,"F:\\SikuliFiles\\Fruites\\Mangoes.jpg");
		s.click(openButton);



	}

}
