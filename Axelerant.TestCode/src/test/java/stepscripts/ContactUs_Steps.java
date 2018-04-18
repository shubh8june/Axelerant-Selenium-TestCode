package stepscripts;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;



import applibs.CommonLib;
import applibs.ContactUsLib;
import applibs.ResultsLib;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUs_Steps {
	public static WebDriver driver;
	ContactUsLib contus;
	CommonLib common;
	ResultsLib rs;
	@Given("^User is on Contact Us Page$")
	public void launch_Home_Page() throws Throwable {
			common=new CommonLib();
			driver = common.launchHomePage();
			contus = new ContactUsLib();
			contus.launchContactUs(driver);
		 }
 
	
	@When("^User enter \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void ContactUs_DataEntry(String subjecthead, String email, String message) throws Throwable
	{
		contus.ContactUs_DataEntry(driver, subjecthead, email, message);
		
	}
	
	@Then("^Validate Message Displayed$")
	public void message_displayed() throws Throwable {
		Assert.assertTrue("Error: Contact Us form NOT submitted successfully.", driver.getPageSource().contains("Your message has been successfully sent to our team."));
		driver.quit();
		
	}
}
