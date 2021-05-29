import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;

public class PubMed {
	
	@Test
	public static void getAbstractText1() {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\unni_\\OneDrive\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://pubmed.ncbi.nlm.nih.gov/advanced/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        //actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        
		try {      
		        Assert.assertEquals(actualTitle, expectedTitle,"Test Failed");
		}
		catch(Exception e)
		{
		
		}
		finally {       
		        //close Fire fox
		        driver.close();
		}
       
    }
	


}
