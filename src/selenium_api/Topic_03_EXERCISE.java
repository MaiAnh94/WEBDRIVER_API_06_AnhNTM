package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_03_EXERCISE {
  WebDriver driver ;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }
  
  @Test
  public void TC_01_Kiemtraphantu() {
	  //Truy cập trang
	  driver.get("http://daominhdam.890m.com/");
	  
	  //Kiểm tra các phần tử sau hiển thị trên trang
	  WebElement Email = driver.findElement(By.xpath("//input[@id='mail']"));
	  if (Email.isDisplayed()) {
		System.out.println("Email hiển thị");
		Email.sendKeys("Automation Testing");
	}else {
		System.out.println("Email không hiển thị");
	}
	  
	  WebElement ageRadio = driver.findElement(By.xpath("//input[@id ='under_18']"));
	  if (ageRadio.isDisplayed()) {
		System.out.println("Age hiển thị");
		ageRadio.click();
	} else {
		System.out.println("Age không được hiển thị");
	}
	  WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
	  if (Education.isDisplayed()) {
		  System.out.println("Education đươc hiển thị");
		  Education.sendKeys("Automation Testing");
		
	} else {
		System.out.println("Education không hiển thị");
	}
  }
  
  @Test
  public void TC_02_Kiemtraenable_disable() {
	  driver.get("http://daominhdam.890m.com/");
	  
	  //Kiểm tra các phần tử sau enable
	  WebElement Email = driver.findElement(By.xpath("//input[@id='mail']"));
	  WebElement Age  = driver.findElement(By.xpath("//input[@id ='under_18']"));
	  WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
	  WebElement Job_Role_01 = driver.findElement(By.xpath("//select[@id='job1']"));
	  WebElement Interests_Development = driver.findElement(By.xpath("//input[@id='development']"));
	  WebElement Slider_01 = driver.findElement(By.xpath("//input[@id='slider-1']"));
	  WebElement Button_enabled = driver.findElement(By.xpath("//button[@id='button-enabled']"));
	  WebElement Password = driver.findElement(By.xpath("//input[@id ='password']"));
	  WebElement Age_disabled = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
	  WebElement Biography = driver.findElement(By.xpath("//textarea[@id ='bio']"));
	  WebElement Job_Role_02 = driver.findElement(By.xpath("//select[@id ='job2']"));
	  WebElement Interests_disabled = driver.findElement(By.xpath("//input[@id ='check-disbaled']"));
	  WebElement Slider_02 = driver.findElement(By.xpath("//input[@id ='slider-2']"));
	  WebElement Button_disabled = driver.findElement(By.xpath("//button[@id='button-disabled']"));
	  
	  isElement(Email);
	  isElement(Age);
	  isElement(Education);
	  isElement(Job_Role_01);
	  isElement(Interests_Development);
	  isElement(Slider_01);
	  isElement(Button_enabled);
	  isElement(Password);
	  isElement(Password);
	  isElement(Age_disabled);
	  isElement(Biography);
	  isElement(Job_Role_02);
	  isElement(Interests_disabled);
	  isElement(Slider_02);
	  isElement(Button_disabled);
	  
  }
  
  @Test
  public void TC_03_KiemtraChon() {
	  driver.get("http://daominhdam.890m.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  WebElement Age_under18 = driver.findElement(By.xpath("//input[@id ='under_18']"));
	  WebElement Interests_Development = driver.findElement(By.xpath("//input[@id='development']"));
	  
	  Age_under18.click();
	  isSelected(Age_under18);
	 
	  Interests_Development.click();
	  isSelected(Interests_Development);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public void isElement(WebElement element) {
	  if (element.isEnabled()) {
		System.out.println("Element is enabled");
	} else {
		System.out.println("Element is disabled");
	}
  }
  
  public void isSelected(WebElement element1) {
	  if (element1.isSelected()) {
		System.out.println("Element is Selected");
	} else {
		System.out.println("Element is Diselected");
		element1.click();
	}
  }
}
