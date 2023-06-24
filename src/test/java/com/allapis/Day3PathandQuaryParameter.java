package com.allapis;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Day3PathandQuaryParameter {

	// https://reqres.in/api/users?page=2&id=5

	@Test
	void TestQuaryAndpath() {

		given()
		.pathParam("mypath", "users")
		.queryParam("page", "2")
		.queryParam("id", "5")

	    .when()
	    .get("https://reqres.in/api/{mypath}")

				
	    .then()
	    .statusCode(200)
	    .log().all()
	    //we can also print those only if we use below process
		.log().body()
		.log().cookies()
		.log().headers();

	}

}
