package runner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProvider.ConfigFileReader;

 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue={"stepscripts"}, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:src/test/java/results/Axelerant-Test-Report.html"}
)
 
public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport() {
		ConfigFileReader configFileReader= new ConfigFileReader();
		Reporter.loadXMLConfig(new File(configFileReader.getReportConfigPath()));
		
	}

}