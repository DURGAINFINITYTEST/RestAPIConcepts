package com.allapis;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Day6JSONSchema {

	@Test
	void jsonSchema() {

		given()
		.when()
		.get("my url")
		.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("coverterd schema at project folder"));

	}

	// xml to xsd

	@Test
	void xmlSchema() {

		given().when().get("my url").then().assertThat()
				.body(RestAssuredMatchers.matchesXsdInClasspath("coverterd xml at project folder"));
	}

}
