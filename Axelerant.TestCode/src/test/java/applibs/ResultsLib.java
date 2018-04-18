package applibs;
/** This class file is used to store the console output to result folder.

 *  
 * @author Shubhangi Bheda
 * @Created On: 15 April 2018
 * @Last Updated: 18 April 2018
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ResultsLib {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
    String storyName = this.getClass().getSimpleName();
    String storyDesc = "Calculator Test Story";
    public void saveReport()
    {
    // start reporters
    htmlReporter = new ExtentHtmlReporter("C:\\Reports\\" + storyName + ".html");
    // create ExtentReports and attach reporter(s)
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    // creates a toggle for the given test, adds all log events under it    
    test = extent.createTest(storyName, storyDesc); 

}
}
/** Final variable RESULTPATH. Set the Path of the folder where you want to store the console output. 
public final String RESULTPATH = "C://SeleniumProjects//Axelerant.TestCode//src//test//java//results";
/**

 * @Description: Method to sort save console output in file. Method will generate the file name with date and time.
 * @return: Nothing
 */
/**	public void saveResult(){
PrintStream saveconsole = null;
try {
	Date d = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
	String filename = "//Result_" + dateFormat.format(d) + ".txt";
	saveconsole = new PrintStream(new File(RESULTPATH + filename));
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.setOut(saveconsole);
}*/