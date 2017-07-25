package test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;


public class AccountServiceTest {

	/**
	 * Account exists
	 */
	@Test
	public void testGetById(){
		expect().
		body("accountID", equalTo(1001)).
		body("name", equalTo("John")).
		when().
		get("/revolut/webapi/accounts/1001");
	}
	
	/**
	 * account doesn't exists
	 */
	@Test
	public void testAccountNotFound() {
		expect().
			body("code", equalTo(404)).
			body("message", containsString("not found")).
		when().
			get("/revolut/webapi/accounts/111");
	}
}
