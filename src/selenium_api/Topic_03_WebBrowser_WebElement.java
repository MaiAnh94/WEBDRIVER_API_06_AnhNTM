package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Test
public class Topic_03_WebBrowser_WebElement {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  //driver = new ChromeDriver();
	  
	  
}
  
  public void TC_01_WebBrowerCommand() {
	  //mở 1 đường link bất kỳ , hàm get không trả về giá trị
	  driver.get("");
	  
	  //chỉ đóng tab hiện tại đang active- nếu có 1 tab nó đóng luôn trình duyệt
	  driver.close();
	  
	  //đóng cả trình duyệt mà không quan tâm có bao nhiêu tab
	  driver.quit();
	  
	  //Trả về URl hiện tại của page đó
	  String homePageUrl = driver.getCurrentUrl();
	  System.out.println(homePageUrl);
	  //http://live.guru99.com/
	  
	  //Trả về src của trang đang sử dụng
	  //Muốn kiếm tra 1 element /text nắm trong page không thể locate
	  String HomePageSource = driver.getPageSource();
	  Assert.assertTrue(HomePageSource.contains(""));
	  System.out.println(HomePageSource);
	  
	  //Kiểm tra 1 tille page có đúng hay không?
	  String HomePageTitle = driver.getTitle();
	  //Assert.assertTrue();//
	  
	  //xử lý swicth nhiều cửa số vs nhau
	  driver.getWindowHandle();
	  driver.getWindowHandles();
	  
	  //Những thuộc tính có Option phía sau
	  //wait cho element đươc xuất hiện trong 30s
	  
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	 //wait cho page được load lên thành công trong 30s
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
	 //Open màn hình fullscreen (F11)
	 driver.manage().window().fullscreen();
	 
	 //Mở rộng cửa sổ của browers
	 driver.manage().window().maximize();
	 
	 //back về trang trước đó
	 driver.navigate().back();
	 
	 //next sag trang 
	 driver.navigate().forward();
	 
	 //F5 
	 driver.navigate().refresh();
	 
	 //chuyển qua 1 alert nào đó
	 driver.switchTo().alert();
	 
	 //Frame/ Iframe
	 driver.switchTo().frame("");
	 
	  driver.findElement(By.id("")).click();
	  
	  //
	 WebElement element = driver.findElement(By.xpath(""));
	 element.sendKeys("");
	 element.getAttribute("");
	 element.getCssValue("");
	 //lấy ra vị trí của Element nằm trong độ phân giải màn hình, lấy ra kích thước bên ngoài
	 element.getLocation();
	 
	 //chiều rộng chiểu cao của Element đang xét, lấy kích thước bên trong
	 element.getSize();
	 
	 //tagname = thẻ htlm
	 element.getTagName();
	 //lấy text của màn hình, xử lý vs các TH khi lấy msg lỗi
	 element.getText();
	 //Kiểm tra 1 Element có hiển thị hay không? -> cho tất cả các loại Element
	 Assert.assertTrue(element.isDisplayed()); // luôn đi kem vs 
	 //Boolean : true /F
	 
	 //
	 
  }

  @AfterClass
  public void afterClass() {
  }

}
