package com.allapis;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Day2ByUsingExternalSON {

	@Test
	void testPostUsingExternalSON() throws Exception {

		File dat = new File("C:\\Users\\katak\\eclipse-workspace\\RestAPI\\src\\test\\java\\body.json");
		FileReader fr = new FileReader(dat);
		JSONTokener data = new JSONTokener(fr);
		JSONObject ob = new JSONObject();

		given().contentType("application/json").body(ob)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201);

	}

}
