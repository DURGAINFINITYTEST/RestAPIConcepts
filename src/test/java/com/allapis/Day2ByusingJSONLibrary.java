package com.allapis;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import net.minidev.json.JSONObject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Day2ByusingJSONLibrary {

	@Test
	void testPostUsingJosnLibrary() {

		JSONObject myData = new JSONObject();
		myData.put("name", "Prasadkatak");
		myData.put("job", "tester123");

		given().contentType("application/json").body(myData.toString())

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201);

	}

}
