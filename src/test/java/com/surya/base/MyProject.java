package com.surya.base;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyProject {

	
	public static WebDriver driver;
	
	
	@BeforeTest
	public void setUp()
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void linkText()
	{
		
		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		System.out.println(driver.getTitle());
		
	}
	
	@Test(priority=1)
	public void userName()
	{
	WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
	user.sendKeys("surya");
	}
	
	@Test(priority=2)
	public void passWord()
	{
	WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
	pass.sendKeys("Test@123");
	}
	
	@Test(priority=3)
	public void comments()
	{
	WebElement comm=driver.findElement(By.xpath("//*[@name='comments']"));
	comm.clear();
	}
	
	@Test(priority=4)
	public void commentsAgain()
	{
	WebElement comm=driver.findElement(By.xpath("//*[@name='comments']"));
	comm.sendKeys("hello Faisal");
	}
	
	@Test(priority=5)
	public void checkbox()
	{
		int totalcheckboxes = 0;
	WebElement ele=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
	ele.click();
	Boolean exp=ele.isSelected();
	
	Boolean act=true;
	System.out.println(exp);
	Assert.assertEquals(act,exp);
	List <WebElement> s=driver.findElements(By.xpath("//input[@type='checkbox']"));
	totalcheckboxes=s.size();
	System.out.println(totalcheckboxes);
	
	}
	
	@Test(priority=6)
	public void radiobox()
	{
		
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		int totalradioboxes = 0;
	List <WebElement> sizeofradio=driver.findElements(By.xpath("//*[@type='radio']"));
	totalradioboxes=sizeofradio.size();
	System.out.println(totalradioboxes);
	int exp=3;
	Assert.assertEquals(totalradioboxes,exp);
	
	}
	
	@Test(priority=7)
	public void dropDown()
	{
		WebElement dropdown=driver.findElement(By.xpath("//*[@name='dropdown']"));
		Select s=new Select(dropdown);
		List<WebElement> list=s.getOptions();
 int totaloptions=list.size();
 System.out.println("The total dropdownoption :" + totaloptions);
 
 int exp=6;
 
 Assert.assertEquals(totaloptions, exp);
	
		}
	
	@Test(priority=8)
	public void selectDropDown() throws InterruptedException
	{
		WebElement dropdown=driver.findElement(By.xpath("//*[@name='dropdown']"));
		Select s=new Select(dropdown);
		s.selectByIndex(4);
		
		Thread.sleep(5000);
		s.selectByVisibleText("Drop Down Item 6");
}
	
	@Test(priority=9)
	public void submit()
	{
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		
}
	
	@Test(priority=10)
	public void childWindowValidation()
	{
		Set<String> allWindowHandles = driver.getWindowHandles();
	 
	for(String handle : allWindowHandles)
	{
	System.out.println("Window handle - > " + handle);
	}
	 
	WebElement st=driver.findElement(By.xpath("//p[contains(text(),'You submitted a form. The details below show the v')]"));
	String act=st.getText();
	System.out.println(act);
	 Assert.assertEquals(act, "You submitted a form. The details below show the values you entered for processing.");
	}
//		
}	
