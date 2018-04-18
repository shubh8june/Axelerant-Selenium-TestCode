package applibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigFileReader;
/** This class file can be used to define  all the methods and objects which can be used through out the application.
 *  
 * @author Shubhangi Bheda
 * @Created On: 15 April 2018
 * @Last Updated: 18 April 2018
 */
public class CommonLib {
	/**
     * @Description: To launch the Home page. Launch the application URL as defined is automation.properties. 
     * @return: Nothing
     */
	public WebDriver launchHomePage()
	{
		ConfigFileReader configFileReader= new ConfigFileReader();
		WebDriver driver=null;
		if(configFileReader.getBrowserType().equalsIgnoreCase("Firefox"))
		{	
			System.setProperty("webdriver.firefox.marionette", configFileReader.getDriverPath());
			driver = new FirefoxDriver();
		}else if(configFileReader.getBrowserType().equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			driver = new ChromeDriver();
		}
		
			driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
			driver.get(configFileReader.getApplicationUrl());
        return driver;
	}
}
