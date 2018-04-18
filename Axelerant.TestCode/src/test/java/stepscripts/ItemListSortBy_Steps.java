package stepscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import applibs.CommonLib;
import applibs.ItemSortBy;
import applibs.ResultsLib;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ItemListSortBy_Steps {
	WebDriver driver;
	CommonLib common;
	ItemSortBy sort;
	ResultsLib rs;
	@Given("^User launches shopping website$")
	public void Go_to_Home_Page() throws Throwable {
		common=new CommonLib();
	
		driver = common.launchHomePage();
		sort = new ItemSortBy();
		 }
	
	@When("^User click on Women link to view all the items available under women category$")
	public void click_Women_link() throws Throwable {
		driver.findElement(By.partialLinkText("Women")).click();
	}
	
	@And("^User select sort by otion Prize:Highest First$")
	public void sort_by_higest_to_lowest() throws Throwable {
	{
		sort.selectSortByOption(driver, "price:desc");
	}
	}

	@Then("^Items are listed according to prize Higest First$")
	public void sort_validation() throws Throwable {
		
		sort.sortbyprice_highesttolowest(driver);
		driver.quit();
		
	}

}
