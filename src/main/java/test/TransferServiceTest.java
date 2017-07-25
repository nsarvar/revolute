package test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;


import org.json.*;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class TransferServiceTest {
	
	Object jsonObject;
	
	
	/**
	 * Checks if the sender and receiver account id is the same
	 * @throws URISyntaxException
	 */
	@Test public void TransferSameAccountTest() throws URISyntaxException{
		jsonObject = new JSONObject()
			.put("fromAccountID", 1001)
			.put("toAccountID", 1001)
			.put("amount", 100.0)
			.put("note", "test test");
	
		given()
			.contentType("application/json")
			.body(jsonObject.toString())
			.when()
			.post(new URI("/revolut/webapi/transfers/make"))
			.then()
			.assertThat()
			.body("code", equalTo(500))
			.body("message", containsString("same account"));
	}
	

	/**
	 * tests if the balance is not enough
	 * @throws URISyntaxException
	 */
	@Test public void balanceSenderTest() throws URISyntaxException{
		jsonObject = new JSONObject()
			.put("fromAccountID", 1001)
			.put("toAccountID", 1002)
			.put("amount", 3000.0)
			.put("note", "test test");
	
		given()
			.contentType("application/json")
			.body(jsonObject.toString())
			.when()
			.post(new URI("/revolut/webapi/transfers/make"))
			.then()
			.assertThat()
			.body("code", equalTo(500))
			.body("message", containsString("not enough"));
	}
	
 
	/**
	 * test for successful transfer
	 * @throws URISyntaxException
	 */
	@Test
	public void moneyTransferTest() throws URISyntaxException {
		jsonObject = new JSONObject()
								.put("fromAccountID", 1001)
								.put("toAccountID", 1002)
								.put("amount", 100.0)
								.put("note", "test test");
		
				given()
				.contentType("application/json")
		    	.body(jsonObject.toString())
		        .when()
		        .post(new URI("/revolut/webapi/transfers/make"))
		        .then()
		        .assertThat()
		        .body("message", equalTo("Success"));
	}
}
