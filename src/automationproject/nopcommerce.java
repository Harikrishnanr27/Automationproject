package automationproject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class nopcommerce {
	WebDriver driver;
	@BeforeTest
	public void start()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void starts()
	{
		driver.get("https://demo.nopcommerce.com/");
	}
	@Test
	public void test1register() throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("akhil");
		driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("r");
		
		WebElement day=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
		Select dayelement=new Select(day);
		dayelement.selectByValue("2");
		WebElement month=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]"));
		Select monthelement=new Select(month);
		monthelement.selectByValue("5");
		WebElement year=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]"));
		Select yearelement=new Select(year);
		yearelement.selectByIndex(5);
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("harikrishnanr35@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Company\"]")).sendKeys("abcltd");
		driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).click();
		
		WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		WebElement confirmpassword=driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
		password.sendKeys("nopcommerce#8787");
		Actions act=new Actions(driver);
		act.keyDown(password,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(password,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(confirmpassword,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
		
		driver.findElement(By.xpath("//*[@id=\"register-button\"]")).submit();
	
	}
	@Test
	public void test2login()
	{
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("harikrishnanr35@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("nopcommerce#8787");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).submit();
		}
	@Test
	public void test3cart()
	{
		
		WebElement element=driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(element);
		act.perform();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
	}
	@Test
    public void test4titleverification()
	{

		String expected="nopCommerce";
		String actual=driver.getTitle();
		if(expected.equals(actual))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
	}
	@Test
	public void test5logo()
	{
		 boolean logo=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img")).isDisplayed();
		   if(logo)
		   {
			   System.out.println("logo is present");
		   }
		   else
		   {
			   System.out.println("logo is not present");
		   }
	}
	@Test
	public void test6links()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("no of links"+li.size());
	
	}
	@Test
	public void test7screenshot() throws IOException
	{
	WebElement logos=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
				  File f=logos.getScreenshotAs(OutputType.FILE); 	  
				  FileHandler.copy(f, new File("C:\\Users\\LENOVO\\Documents\\Screenshot2.png"));
	 }
	@AfterMethod
	public void end()
	{
		//driver.close();
	}
	
}






