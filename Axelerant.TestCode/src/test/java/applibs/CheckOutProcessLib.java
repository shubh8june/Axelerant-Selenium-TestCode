package applibs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *  
 * This applib file will define the objects and methods required to perform the complete checout process.
 * @author Shubhangi Bheda
 * @Created On: 15 April 2018
 * @Last Updated: 18 April 2108
 */
public class CheckOutProcessLib{
	WebDriverWait wait;
	/**
     * @Description: To locate the product on Home Page 
     * @return: Nothing
     */
	public void searchProduct(WebDriver driver, String productLabel){ 
		
		driver.findElement(By.partialLinkText(productLabel)).click();
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit")));
	}
	
	/**
     * @Description: To add product to cart 
     * @return: Nothing
     */
	public void addtoCart(WebDriver driver){ 
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(By.name("Submit")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Proceed to checkout']")));
			
	}
	/**

     * @Description: Click proceed to checkout 
     * @return: Nothing
	 * @throws InterruptedException 
     */
	public void proceedtoCheckout(WebDriver driver) throws InterruptedException{ 

		driver.findElement(By.partialLinkText("Proceed to checkout")).click();


	}
	/**
   
     * @Description: Method for Sign in for existing user
     * @return: Nothing
     */
	public void Sign_In(WebDriver driver, String username, String password){ 
	
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
		Assert.assertTrue("Sign in not successfull", driver.getPageSource().contains("Your delivery address"));
		
	}
 
    /** @Description: Complete the process of placing order after signing in 
    * @return: Nothing
    */
	public void placeOrder(WebDriver driver) {
		driver.findElement(By.name("processAddress")).click();
		
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		
		driver.findElement(By.partialLinkText("Pay by check")).click();
		driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
		
	}
}
