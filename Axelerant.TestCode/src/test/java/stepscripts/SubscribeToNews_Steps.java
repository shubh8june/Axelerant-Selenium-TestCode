package stepscripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import com.cucumber.listener.Reporter;

import applibs.CommonLib;
import applibs.ResultsLib;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SubscribeToNews_Steps {
	String randEmail;
	WebDriver driver;
	CommonLib common;
	ResultsLib rs;
	@Given("^Lauch Home Page$")
	public void subscirbe_from_home() throws Throwable {
		common=new CommonLib();
	
		driver = common.launchHomePage();
		 
	}
	
	@When("^User enters valid email address to Newsletter field present at the bottom of the Home page$")
	public void subscribe_to_News() throws Throwable 
	{
		 randEmail = "abc"+ (int)(Math.random()*20)+1 + "@abc.com";
		driver.findElement(By.id("newsletter-input")).sendKeys(randEmail);
		driver.findElement(By.name("submitNewsletter")).click();
		
	}
 
	@Then("^User is subscribed to newsletter successfully$")
	public void validate_subscribed_successfully() throws Throwable
	{
		Assert.assertTrue("Please try again!!", driver.getPageSource().contains("Newsletter : You have successfully subscribed to this newsletter."));
		driver.quit();

	}
	}
