package com.app;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String username = System.getenv("MY_USERNAME");
		String password = System.getenv("MY_PASSWORD");
		String url="https://magento.softwaretestingboard.com/";
		WebDriver driver=new ChromeDriver();
		String[] ids= {"firstname","lastname","email_address","password","password-confirmation"};
		String[] values= {"Test","Account1",username,password,password};
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
//		String password = System.getenv("MY_APP_PASSWORD");
//
//		String url=System.getenv("URL");
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.xpath("//div[@class='panel header']//a[text()='Create an Account']")).click();
		
		for(int i=0;i<5;i++) {
			driver.findElement(By.id(ids[i])).sendKeys(values[i]);
		}
		
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		
		driver.findElement(By.xpath("//div[@class='panel header']//span[contains(text(),'Welcome')]")).isDisplayed();
		
		
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot to a desired location
        File destinationFile = new File("screenshot.png");
        FileUtils.copyFile(screenshot, destinationFile);
		

	}

}
