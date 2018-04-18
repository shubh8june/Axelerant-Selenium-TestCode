package applibs;
/** This class file can be used to define  all the methods and objects for ContactUse Page.

 *  
 * @author Shubhangi Bheda
 * @Created On: 15 April 2018
 * @Last Updated: 18 April 2018
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ItemSortBy {
	/**

     * @Description: Method to sort Items listed with otion Price: Highest to lowest
     * @return: Nothing
     */
	public void sortbyprice_highesttolowest(WebDriver driver) {
		// scrape price elements
		
				List<WebElement> price = driver.findElements(By.xpath("//div[@class='right-block']/div[@class='content_price']/span[@class='price product-price']"));
				
				// extract the prices from the price elements and store in a List
				List<String> prices = new ArrayList<String>();
				for (WebElement e : price)
				{
					prices.add(e.getText());
				}
				
				// make a copy of the list
				List<String> sortedPrices = new ArrayList<String>(prices);

				// sort the list
				Collections.sort(sortedPrices);
				Collections.reverse(sortedPrices);
			
				// true if the prices are sorted
				Assert.assertTrue("Item NOT Sorted Correctly: Prices Highest to Lowest", sortedPrices.equals(prices));
				
	}
	/**

     * @Description: Method to select the option in field "Select By". Accepts parameter as option.
     * @return: Nothing
     */
	public void selectSortByOption(WebDriver driver, String option)
	{
		Select sortby = new Select(driver.findElement(By.id("selectProductSort")));
		sortby.selectByValue(option);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
