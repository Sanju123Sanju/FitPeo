package FitPeo_Revenue_Calculator;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import FitPeo_Constants.constant_Values;






public class FitPeo_Revenue_Calculator_Validation {
	public static WebDriver driver=null;
	public static	JavascriptExecutor js= null;
	public static	Robot r=null;
	public static	 WebElement slider=null;
	public static	String price= null;
  @Test(priority=0)
public  void Navigate_to_the_FitPeo_Homepage() {
	  
	   driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
			driver.get(constant_Values.HomepageUrl);
			System.out.println("hello homepage");
		
	  
	  
  }
  
  
  @Test(priority=1)
public  void Navigate_to_Revenue_Calculator_Page() {
	  
	 driver.findElement(By.xpath("//a[@href='/revenue-calculator']")).click();
	  
  }
  
	  @Test(priority = 2) 
	  public void Scroll_Down_to_the_Slider_section() throws Exception { 
		  Thread.sleep(3000); 
		  js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,550)", "");
	  
	  }
	 
  
  @Test(priority=3)
  public  void Adjust_the_Slider() throws Exception {
		
	  Thread.sleep(3000);
	  slider = driver.findElement(By.xpath("//input[@aria-orientation='horizontal']"));
	 	
	  Actions act= new Actions(driver);
      act.dragAndDropBy(slider, 94, 0).perform(); 
      
      Thread.sleep(3000);
      
		   r= new Robot();
		  r.keyPress(KeyEvent.VK_DOWN);
		  r.keyRelease(KeyEvent.VK_DOWN); r.keyPress(KeyEvent.VK_DOWN);
		  r.keyRelease(KeyEvent.VK_DOWN); r.keyPress(KeyEvent.VK_DOWN);
		  r.keyRelease(KeyEvent.VK_DOWN);
		 	  
	  }
  
  @Test(priority=4)
  public void Update_the_Text_Field() throws Exception {
	  
 Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@type='number']")).click();
	  
	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	  
	  r.keyPress(KeyEvent.VK_5);
	  r.keyRelease(KeyEvent.VK_5);
	  r.keyPress(KeyEvent.VK_6);
	  r.keyRelease(KeyEvent.VK_6);
	  r.keyPress(KeyEvent.VK_0);
	  r.keyRelease(KeyEvent.VK_0);
	
}
  @Test(priority=5)
  public void Validate_Slider_Value() throws Exception {
	  Thread.sleep(3000);
	  slider = driver.findElement(By.xpath("//input[@aria-orientation='horizontal']"));
	  String slider_V= slider.getText(); 
	  
		System.out.println("validated the Slider Value  "+ slider_V);
	
	  
	  
}
  @Test(priority=6)
  public void Select_CPT_Codes() {
	  

	  driver.findElement(By.xpath("//input[@type='number']")).click();
	 	  
	 	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	 	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	 	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	 	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	 	  r.keyPress(KeyEvent.VK_BACK_SPACE);
	 	  r.keyRelease(KeyEvent.VK_BACK_SPACE);
	 	  
	 	  r.keyPress(KeyEvent.VK_8);
	 	  r.keyRelease(KeyEvent.VK_8);
	 	  r.keyPress(KeyEvent.VK_2);
	 	  r.keyRelease(KeyEvent.VK_2);
	 	  r.keyPress(KeyEvent.VK_0);
	 	  r.keyRelease(KeyEvent.VK_0);
	 		 		  
	 		  js.executeScript("window.scrollBy(0,550)", "");
	 		  driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	 			
	 			  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
	 			  driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	 			  driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
	
}
  
  @Test(priority=7)
  public void Validate_Total_Recurring_Reimbursement() {

		 price=  driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")).getText();
	String	Expected_value="$110700";
	Assert.assertEquals(price,Expected_value);
	System.out.println("Validated the Total Recurring Reimbursement  "+ price);
		
		 
}
  @Test(priority=8)
  public void Shows_the_value() {
	  System.out.println("Total Recurring Reimbursement for all Patients Per Month  "+price);
}
  
}
