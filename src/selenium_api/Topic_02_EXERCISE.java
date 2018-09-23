package selenium_api;

import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.server.Authentication.Failed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_EXERCISE {
	WebDriver driver ;
	String email;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void TC_01_VerifyURLandtitle() {
	  //truy cập trang web
	  driver.get("http://live.guru99.com/");
	  String homePageTitle = driver.getTitle();
	  Assert.assertEquals(homePageTitle, "Home page");
	  
	  //Click vào link "My Account" để tới trang đăng nhập
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text() ='My Account']")).click();
	  
	  //Click CREATE AN ACCOUNT button để tới trang đăng kí tài khoản
	  driver.findElement(By.xpath("//form[@id='login-form']//span[text() ='Create an Account']")).click();
	  
	 //Back lại trang đăng nhập
	  driver.navigate().back();
	  
	  //Kiểm tra url của page đăng nhập
	  String urlPageLogin = driver.getCurrentUrl();
	  Assert.assertEquals(urlPageLogin, "http://live.guru99.com/index.php/customer/account/login/");
	  
	  //Forward tới trang tạo tài khoản
	  driver.navigate().forward();
	  
	  //Kiểm tra url của page tạo tài khoản 
	  String urlPageCreate = driver.getCurrentUrl();
	  Assert.assertEquals(urlPageCreate,"http://live.guru99.com/index.php/customer/account/create/");
	  
  }
  
  @Test
  public void TC_02_Loginempty() {
	  //Truy cập vào trang
	  driver.get("http://live.guru99.com/");
	  
	  //Click vào link "My Account"
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text() ='My Account']")).click();
	  
	  //Để trống Username/ Password
	  //Click Login button
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  //Verify error message xuất hiện tại 2 field
	  String emailErr = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals(emailErr, "This is a required field.");
	  System.out.println(emailErr);
	  
	  String passErr = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals(passErr, "This is a required field.");
	  System.out.println(passErr);
	  
  }
  
  @Test
  public void TC_03_LoginwithEmailinvalid() {
	  //Truy cập vào trang
	  driver.get("http://live.guru99.com/");
	  
	  //Click vào link "My Account"
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text() ='My Account']")).click();
	  
	  //Nhập email invalid
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("23434234@12312.123123");
	  
	  //Click Login button
	  driver.findElement(By.xpath("//button[@id ='send2']")).click();
	  
	 // Verify error message xuất hiện
	  String emailErr1 = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	  Assert.assertEquals(emailErr1, "Please enter a valid email address. For example johndoe@domain.com.");
	  System.out.println(emailErr1);
	  
  }
  
  @Test
  public void TC_04_LoginwithPasswordincorrect() {
	  //Truy cập vào trang
	  driver.get("http://live.guru99.com/");
	  
	  //Click vào link "My Account"
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text() ='My Account']")).click();
	  
	  //Nhập email correct and password incorrect
	  driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  
	  //Click Login button
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  //Verify error message xuất hiện
	  String passErr1 = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(passErr1, "Please enter 6 or more characters without leading or trailing spaces.");
	  System.out.println(passErr1);
  }
  
  @Test
  public void TC_05_Createanaccount() {
	  //Truy cập vào trang
	  driver.get("http://live.guru99.com/");
	  
	  //Click vào link "My Account"
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text() ='My Account']")).click();
	  
	  //Click CREATE AN ACCOUNT 
	  //driver.findElement(By.xpath("//form[@id='login-form']//span[text() ='Create an Account']")).click();
	  driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	  
	  //Nhập thông tin hợp lệ vào tất cả các field
	  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("mai anh");
	  
	  driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("nguyen thi");
	  
	  email = "Selenium006" + randomData() + "@gmail.com";
	  driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	  
	  driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
	  
	  //Click REGISTER button
	  driver.findElement(By.xpath("//form[@id='form-validate']/div[2]/button")).click();
	  
	  //Verify message xuất hiện khi đăng kí thành công
	  String msgSuccess = driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
	  Assert.assertEquals(msgSuccess, "Thank you for registering with Main Website Store.");
	  
	  //Logout khỏi hệ thống
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text() ='Account']")).click();
	  driver.findElement(By.xpath("//div[@id='header-account']//a[text() ='Log Out']")).click();
	  
	  //Kiểm tra hệ thống navigate về Home page
	  driver.navigate().refresh();
  }

  @AfterClass
  public void AfterClass() {
	  driver.quit();
  }
  public int randomData() {
	  Random random = new Random();
	  int number = random.nextInt(999999);
	  return number;
  }

}
