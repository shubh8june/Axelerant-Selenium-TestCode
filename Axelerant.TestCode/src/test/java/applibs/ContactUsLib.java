package applibs;
/** This class file can be used to define  all the methods and objects for ContactUse Page.

 *  
 * @author Shubhangi Bheda
 * @Created On: 15 April 2018
 * @Last Updated: 18 APril 2018
 */


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsLib {
	/**

     * @Description: To launch Contact Us form from Home Page 
     * @return: Boolean true if contact us page displayed successfully.
     */
	public void launchContactUs(WebDriver driver){
		driver.findElement(By.linkText("Contact us")).click();
		Assert.assertTrue("Oops!! Contact Us Form Not Launched.",driver.getPageSource().contains("send a message"));
	}
	/**

     * @Description: Method to enter the data for Contact Us form. It accepts data Subject Category, email address and Message.
	 * @return: Boolean true if contact us page displayed successfully.
     */
	public void ContactUs_DataEntry(WebDriver driver, String subjecthead, String email, String message)
	{
		Select dropdown = new Select(driver.findElement(By.id("id_contact")));
		dropdown.selectByVisibleText(subjecthead);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("message")).sendKeys(message);
		driver.findElement(By.id("submitMessage")).click();
	}
	
}

