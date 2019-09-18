package com.model.action;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//pageLoad
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		System.out.println("current url is: " +url);
		String title=driver.getTitle();
		System.out.println("title of webpage is :" + title);
		//get all hyperlinks
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		int count=ls.size();
		System.out.println("The number of hyperlinks on webpage are:"+count);
		//doubleclick
		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("fitbit");
		driver.findElement(By.cssSelector("input[type='submit']")).submit();
		
		//implicitwait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title1=driver.getTitle();
		System.out.println("title of web page is:"+title1);
		driver.navigate().back();
		//contextClick rightclick
		WebElement rightclick=driver.findElement(By.linkText("Amazon Pay"));
		Actions action1=new Actions(driver);
		action1.contextClick(rightclick).build().perform();
		//moveToElement
		Thread.sleep(5000);
		WebElement signin=driver.findElement(By.id("nav-link-yourAccount"));
		Actions action2=new Actions(driver);
		action2.moveToElement(signin).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='nav-text'][.='Your Orders']")).click();
		//wait email_id
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
		WebElement email=driver.findElement(By.id("ap_email"));		
		boolean act_flag=email.isDisplayed();
		if(act_flag==true)
		{
			driver.findElement(By.id("ap_email")).sendKeys("suniladhav10@gmail.com");	
		}
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.close();	
	}
	}

