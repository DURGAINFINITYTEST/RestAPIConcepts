package com.allapis;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {
	public static int id = 0;

	@Test(priority = 1)
	void getUser() {

		given()

				.when()

				.get("https://reqres.in/api/users?page=2")

				.then()
				.statusCode(200) // statuscode
				.body("page", equalTo(2)) // body
				.log().all(); // display all body

	}

	@Test(priority = 2)
	void createUser() {
		HashMap map = new HashMap();
		map.put("name", "morpheus");
		map.put("job", "leader");

		id = given().contentType("application/json").body(map)

				.when()

				.post("https://reqres.in/api/users")
				.jsonPath().getInt("id");

	}

	@Test(priority = 3, dependsOnMethods = { "createUser" })
	void updateUser() {

		HashMap map1 = new HashMap();
		map1.put("name", "morpheus");
		map1.put("job", "zion resident");

		given()

				
				.contentType("application/json")
				.body(map1)
				.when()
				.post("https://reqres.in/api/users/" + id)

				.then()
				.statusCode(201) // statuscode for creating user
				.log().all(); // display

	}

	@Test(priority = 4, dependsOnMethods = { "updateUser" })
	void deleteUser() {

		when().delete("https://reqres.in/api/users/2")

				.then().statusCode(204).log().all();
	}
}
