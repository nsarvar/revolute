package test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;


public class AccountServiceTest {

	@Test
	public void testGetById(){
		expect().
		body("accountID", equalTo(1001)).
		body("name", equalTo("John")).
		when().
		get("/revolute/webapi/accounts/1001");
	}
	
	@Test
	public void testAccountNotFound() {
		expect().
			body("code", equalTo(404)).
			body("message", containsString("not found")).
		when().
			get("/revolute/webapi/accounts/111");
	}
}
