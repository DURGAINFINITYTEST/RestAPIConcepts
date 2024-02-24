package com.allapis;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequests {

	public static int id = 0;

	@Test(priority = 1)
	void getUser() {

		when()

				.get("https://reqres.in/api/users?page=2")

				.then().statusCode(200) // statuscode
				.body("page", equalTo(2)) // body6+
				.log().all(); // display all body

	}

	@Test(priority = 2)
	void createUser() {

		/*
		 * HashMap map = new HashMap(); map.put("name", "morpheus"); map.put("job",
		 * "leader");
		 * 
		 * given() .contentType("application/json") .body(map)
		 * 
		 * .when()
		 * 
		 * .post("https://reqres.in/api/users")
		 * 
		 * .then() .statusCode(201);
		 */

		HashMap map = new HashMap();
		map.put("name", "morpheuss1");
		map.put("job", "lead");

		id = given()

				.contentType("application/json").body(map)

				.when()

				.post("https://reqres.in/api/users").jsonPath().getInt("id");

	}

	@Test(priority = 3, dependsOnMethods = { "createUser" })
	void updateUser() {

		HashMap map1 = new HashMap();
		map1.put("name", "morpheus1");
		map1.put("job", "zion resident");

		given()

				.contentType("application/json").body(map1)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200) // statuscode for creating user
				.log().all(); // display

	}

	@Test(priority = 4, dependsOnMethods = { "updateUser" })
	void deleteUser() {

		when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();
	}
}
