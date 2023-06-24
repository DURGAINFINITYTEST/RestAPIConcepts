package com.allapis;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class Day4validations {
	@Test
	void responce() {

		// if you want to validate the body in praticular one
		// in that we are copy the responce body then paste into json path finder then
		// we will identfy the path

		// body("json validater",equalTo("we pass the text"));

		Response res = given()

				.contentType("ContentType.JSON")

				.when().get("https://reqres.in/api/users");

		JSONObject jo = new JSONObject(res.toString());

//		Assert.assertEquals(res.getStatusCode(), 200);
//		System.out.println(res.getTime());
//		System.out.println(res.time());

		// String text=res.jsonPath().get("we pass the json path").toString();
		// Assert.assertEquals(text,"the actual text");

		// extarct the value and then converted into the String

		// search the particular text
		// first we will try to read the the these

	}

}
