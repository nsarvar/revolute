package test;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import org.json.*;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TransferServiceTest {
	
	
	/**
	 * Testing if the transfer is working correctly
	 * @throws URISyntaxException
	 */
	@Test
	public void moneyTransferTest() throws URISyntaxException {
		JSONObject jsonObject = new JSONObject()
								.put("fromAccountID", 1001)
								.put("toAccountID", 1002)
								.put("amount", 100.0)
								.put("note", "test test");
		
		ValidatableResponse r = given()
		    	.contentType("application/json").
		    	body(jsonObject.toString()).
		        when().
		        post(new URI("/revolute/webapi/transfers/make"))
		        .then()
		        .assertThat()
		        .body("message", equalTo("Success"));
	}
	

}
