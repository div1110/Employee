package employeeapi.base;
import org.testng.annotations.BeforeClass;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Testbase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="5";
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		logger=Logger.getLogger("GetEmployeeDetails");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.INFO);	
		
	}
}
