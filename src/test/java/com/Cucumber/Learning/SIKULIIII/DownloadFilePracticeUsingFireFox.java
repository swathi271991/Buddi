package com.Cucumber.Learning.SIKULIIII;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadFilePracticeUsingFireFox {

	WebDriver driver;
	
	//when uploading files through SIKULI change display resolution of laptop to 1280*720

	@Test
	public void test()
	{


		FirefoxProfile profile=new FirefoxProfile();

		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf"); // set Mime type according to your file format
		profile.setPreference("browser.download.manager.showWhenStarting", false);

		//download files in desired location
		profile.setPreference("browser.download.dir","C:\\Downloadedfiles");
		profile.setPreference("browser.download.folderList", 2); 
		profile.setPreference("pdfjs.disabled", true); // only for pdf file

		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);


		//download files in required location using firefox

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\graje\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));


		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Swathichaganti");

		driver.findElement(By.id("createTxt")).click();

		WebElement link = driver.findElement(By.xpath("//a[@id ='link-to-download']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(link));

		link.click();

		File f = new File("C:\\Users\\graje\\Downloads\\info.txt");

		if(f.exists())
		{
			System.out.println("File text document uploaded--pass");
		}
		else
		{
			System.out.println("File text documentnot uploaded--fail");
		}

		WebElement pdftextbox = driver.findElement(By.id("pdfbox"));

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", pdftextbox);

		pdftextbox.sendKeys("PDF doc swathi");

		driver.findElement(By.id("createPdf")).click();

		WebElement pdflink = driver.findElement(By.xpath("//a[@id ='pdf-link-to-download']"));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait1.until(ExpectedConditions.visibilityOf(pdflink));

		pdflink.click();

		File fs = new File("C:\\Users\\graje\\Downloads\\info.pdf");

		if(fs.exists())
		{
			System.out.println("PDF uploaded--pass");
		}
		else
		{
			System.out.println("PDF not uploaded--fail");
		}





	}


}
