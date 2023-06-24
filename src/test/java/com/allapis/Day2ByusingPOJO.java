package com.allapis;

import static io.restassured.RestAssured.given;

import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Day2ByusingPOJO {
     @Test
	void testPostUsingPOJO() {

		Day2CreateDataByUsingPOJO data = new Day2CreateDataByUsingPOJO();
		data.setName("rakesh");
		data.setJob("Automation tester");

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201);

	}

}
