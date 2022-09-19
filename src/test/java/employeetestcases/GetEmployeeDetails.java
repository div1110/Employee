package employeetestcases;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import employeeapi.base.Testbase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class GetEmployeeDetails extends Testbase 
{
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	void getEmpdata() throws InterruptedException
	{
		//Display message.
		logger.info("*****GET ALll EMPLOYEES*******");
		//Capturing the responseBody
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees"+empID);
	}
	void checkResponseBody()
	{
	//Display message.
	logger.info("*****Checking Response-GET ALll EMPLOYEES*******");
	//Capturing the responseBody
	String responseBody = response.getBody().asString();
	Assert.assertEquals(responseBody.contains(empID), true);
	}

	/*
	 * @Test void checkStatusCode() { //Display message.
	 * logger.info("*****Check Status Code-GET ALll EMPLOYEES*******"); //Capturing
	 * the Status Code int StatusCode = response.getStatusCode();
	 * logger.info("Status Code is==>"+StatusCode);
	 * AssertJUnit.assertEquals(StatusCode, 200); }
	 * 
	 * @Test void checkTime() { //Display message.
	 * logger.info("*****Check Time -GET ALll EMPLOYEES*******"); //Capturing the
	 * CheckTime long ResponseTime = response.getTime();
	 * logger.info("Response Time is==>"+ResponseTime); if (ResponseTime>2000) {
	 * logger.warning("Response Time is greater than 200");
	 * Assert.assertTrue(ResponseTime<2000); } }
	 * 
	 * @Test void checkstatusLine() { //Display message.
	 * logger.info("*****Check Status Line -GET ALll EMPLOYEES*******"); //Capturing
	 * the CheckTime String statusLine = response.getStatusLine();
	 * logger.info("Status Line is==>"+statusLine); Assert.assertEquals(statusLine,
	 * "HTTP/1.1 200 OK"); }
	 * 
	 * 
	 * void checkcontentType() { //Display message.
	 * logger.info("*****Check Content Type -GET ALll EMPLOYEES*******");
	 * //Capturing the content String contentType = response.header("Content-Type");
	 * logger.info("Content Type is==>"+contentType);
	 * Assert.assertEquals(contentType, "text/html; charset=UTF-8"); }
	 * 
	 * void checkServerType() { //Display message.
	 * logger.info("*****Check Server Type -GET ALll EMPLOYEES*******"); //Capturing
	 * the content String ServerType = response.header("Server");
	 * logger.info("Server Type is==>"+ServerType); Assert.assertEquals(ServerType,
	 * "nginx"); }
	 * 
	 * void checkContentEncoding() { //Display message.
	 * logger.info("*****Check ContentEncoding -GET ALll EMPLOYEES*******");
	 * //Capturing the content String contentencoding =
	 * response.header("Content-Encoding");
	 * logger.info("Content Encoding is==>"+contentencoding);
	 * Assert.assertEquals(contentencoding, "br"); }
	 */
}
