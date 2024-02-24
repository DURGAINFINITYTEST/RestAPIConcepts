package com.allapis;

import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Day3usingHeaderValidations {

	@Test
	void getHeaderValidations() {
		io.restassured.response.Response res = given()

				.when()
				.get("https://www.google.com/");

		/*
		 * .header("Content-Type", "text/html; charset=ISO-8859-1")
		 * .and()
		 * .header("Content-Encoding", "gzip");
		 * 
` 		 */

		String myheaders = res.getHeader("Content-Type");
		System.out.println(myheaders);

		System.out.println("HEADERS VALIDATIONS");

		Headers totalHeaders = res.getHeaders();
		for (Header oneByOne : totalHeaders) {
			System.out.println(oneByOne.getName() + "  and  " + oneByOne.getValue());
			
		}
	}
}
