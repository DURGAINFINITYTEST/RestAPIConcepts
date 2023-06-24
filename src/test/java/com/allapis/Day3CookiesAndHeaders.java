package com.allapis;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class Day3CookiesAndHeaders {
	/*
	 * @Test void testCookies() {
	 * 
	 * // every time cookies value will changed // we cant expect same values
	 * 
	 * given()
	 * 
	 * .when().get("https://www.google.com/")
	 * 
	 * .then().statusCode(200).log().all();
	 * 
	 * }
	 */

	@Test
	void getCookiesinfo() {

		Response res = given()

				.when()
				.get("https://www.google.com/");

		String Cookie = res.getCookie("AEC"); 
		System.out.println(Cookie);// -------------print the cookie value

		Map<String, String> cookie_value = res.getCookies();
		System.out.println(cookie_value.keySet()); // keys information

		for (String k : cookie_value.keySet()) {

			//String cookieName = res.getCookie(k);
			System.out.println(k + "    :    " + cookie_value);

		}

	}
}
