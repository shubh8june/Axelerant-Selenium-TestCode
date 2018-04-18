package stepscripts;
/** Steps file for Check out Scenario*/
import org.openqa.selenium.WebDriver;

import org.junit.Assert;


import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import applibs.CheckOutProcessLib;
import applibs.CommonLib;
import applibs.ResultsLib;

public class CheckOut_Steps {
	public static WebDriver driver;
	CheckOutProcessLib checkout =  new CheckOutProcessLib();
	CommonLib common;
	ResultsLib rs;
	@Given("^User is on Home Page$")
	public void launch_Home_Page() throws Throwable {
		 common=new CommonLib();
	
		 driver = common.launchHomePage();
		
		}
 
	@When("^User search for product$")
	public void user_search_product() throws Throwable {
		checkout.searchProduct(driver, "Faded Short");
		
		
		}
	
	@When("^Click to Add to Cart$")
	public void click_to_add_cart() throws Throwable
	{
		checkout.addtoCart(driver);
	}
	
	@Then("^Message displayed Product successfully added to your shopping cart and proceed to checkoout$")
	public void product_displayed_Successfully() throws Throwable {
		Assert.assertTrue("Product Not added to cart. Try again!!", driver.getPageSource().contains("Product successfully added to your shopping cart"));
		checkout.proceedtoCheckout(driver);
		checkout.proceedtoCheckout(driver);
	}

	
	@When("^Sign In as Existing User enters \"(.*)\" and \"(.*)\"$")
	public void sign_in(String username, String password) throws Throwable
	{
		System.out.println("Inside");
		checkout.Sign_In(driver, username, password);
		
	}
	
	@When("^Complete Process of checkout$")
	public void place_order() throws Throwable
	{
		checkout.placeOrder(driver);
	}
	@Then("^Order is Placed Successfully$")
	public void order_complete() throws Throwable
	{
		Assert.assertTrue("Oops!Something went wrong. Try again!", driver.getPageSource().contains("Your order on My Store is complete."));
		driver.quit();
	}
}
