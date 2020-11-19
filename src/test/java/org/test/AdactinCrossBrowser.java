package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdactinCrossBrowser {
	
	public static WebDriver driver;
	public static Select s;
	
	@BeforeClass
	@Parameters("Browser")
	private void launch(String ip) {
		if(ip.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\eclipse-workspace\\NewWorkspace\\MavenTestNGAdactinFull\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(ip.equalsIgnoreCase("ff"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\eclipse-workspace\\NewWorkspace\\MavenTestNGAdactinFull\\Driver\\geckodriver.exe");
		driver= new FirefoxDriver();
		}
	}
	
	@Test
	private void method1() {
driver.get("http://adactinhotelapp.com/index.php");
driver.findElement(By.id("username")).sendKeys("shanonfb");
driver.findElement(By.id("password")).sendKeys("francis");
driver.findElement(By.id("login")).click();
	}

	@Test
	private void method2() {
		s= new Select(driver.findElement(By.id("location")));
		s.selectByVisibleText("Sydney");
		
		s= new Select(driver.findElement(By.id("hotels")));
		s.selectByVisibleText("Hotel Creek");
		
		s=new Select(driver.findElement(By.id("room_type")));
		s.selectByVisibleText("Standard");
		
		s=new Select(driver.findElement(By.id("room_nos")));
		s.selectByVisibleText("2 - Two");
		
		driver.findElement(By.id("datepick_in")).sendKeys("31/10/2020");
		driver.findElement(By.id("datepick_out")).sendKeys("02/11/2020");
		
		s=new Select(driver.findElement(By.id("adult_room")));
		s.selectByVisibleText("2 - Two");
	
		s=new Select(driver.findElement(By.id("child_room")));
		s.selectByVisibleText("0 - None");
		
		driver.findElement(By.id("Submit")).click();
	}
	
	@Test
	private void method3() {
driver.findElement(By.id("radiobutton_0")).click();
driver.findElement(By.id("continue")).click();
	}
	
}
