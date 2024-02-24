package com.allapis;

/*hOW MANY WAYS TO CREATE BODY:-----------------------------

1)Hashmap
2)Using org.json
3)Using POJO(PLAIN OLD JAVA OBJECT)
4)Using an external JSON file
*/
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Day2DiffwaysToCreatePostHashMap {
	@Test(priority = 1)
	void testPostusingHshMap() {
		HashMap data = new HashMap();
		data.put("name", "Prasad");
		data.put("job", "tester");

		// entire array value we call them as a single value

//		String coursesarr[] = { "C", "C++" };
//		data.put("courses", coursesarr);
		given()
		.contentType("application/json")
		.body(data)

	   .when()
	   .post("https://reqres.in/api/users")

		.then()
		.statusCode(201)
		.body("name", equalTo("Prasad"));

	}

	@Test(priority = 2)
	void testDelete() {
		given()

				.when()
				.delete("https://reqres.in/api/users")

				.then()
				.statusCode(204);

	}

}
