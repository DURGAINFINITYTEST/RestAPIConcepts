package com.allapis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/*
 * if you want to validate the body in praticular one in that we are copy the
 * responce body then paste into json path finder then we will identfy the path
 * 
 * body("json validater",equalTo("we pass the text"));
 * 
 * Response res = given()
 * 
 * .contentType("ContentType.JSON")
 * 
 * .when().get("https://reqres.in/api/users");
 * 
 * JSONObject jo = new JSONObject(res.toString());
 * 
 * Assert.assertEquals(res.getStatusCode(), 200);
 * System.out.println(res.getTime()); System.out.println(res.time());
 * 
 * String text=res.jsonPath().get("we pass the json path").toString();
 * Assert.assertEquals(text,"the actual text");
 * 
 * extarct the value and then converted into the String
 * 
 * search the particular text first we will try to read the the these
 */

public class Day4validations {

	/*
	 * @Test(priority = 1) void responceUsingThen() {
	 * 
	 * given()
	 * 
	 * .when() .get(" http://localhost:3000/data")
	 * 
	 * .then().statusCode(200)
	 * 
	 * .body("[9].city", equalTo("Atlanta")); }
	 * 
	 * // APPROCH-02
	 * 
	 * @Test(priority = 2) void responceUsingResponceObject() { Response res =
	 * given() .contentType("application/json")
	 * 
	 * .when() .get(" http://localhost:3000/data");
	 * 
	 * Assert.assertEquals(res.getStatusCode(), 200); // statusvalidation
	 * Assert.assertEquals(res.header("Content-Type"),
	 * "application/json; charset=utf-8");
	 * 
	 * String Name = res.jsonPath().get("[9].city").toString(); // convert to object
	 * to string we are using to string() method
	 * 
	 * Assert.assertEquals(Name, "Atlanta"); }
	 */

	@Test
	void testJSONResponseBodyData() {

		Response response = RestAssured.given().contentType("application/json").when()
				.get("https://dummy.restapiexample.com/api/v1/employees");

		String responseBody = response.asString();
		JSONObject jo = new JSONObject(responseBody);
		// all salries
		boolean status = false;
		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
			int salary = jo.getJSONArray("data").getJSONObject(i).getInt("employee_salary");

			System.out.println("salary per month : " + salary);
			if (salary == 320800) {
				status = true;

			}

			

			// if you want particular salary

		}
		Assert.assertEquals(status, true);
		System.out.println("TEST PASSED");

	}
}
