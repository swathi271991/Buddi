package com.Cucumber.Learning.SIKULIIII;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadFilePracticeUsingChrome {

	WebDriver driver;
	
	//when uploading files through SIKULI change display resolution of laptop to 1280*720

	@Test
	public void test()
	{

		//download files in required location using chrome

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory","C:\\Downloadedfiles"); //configure path

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);  // end of code

		System.setProperty("webdriver.chrome.driver", "F:\\SDET_COMPLETE_AUTOMATION\\HYBRID_SDET_PRACTICE\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
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
