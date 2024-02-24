package com.allapis;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;

public class Day5XMLbodyFileUploadAndLoad {

	@Test(priority = 1)
	public void getPostXMLvalidation() {

		given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=6")

				.then().statusCode(200)
				.body("TravelerinformationResponse.travelers.Travelerinformation[3].email",
						equalTo("saiguntur@gmail.com"));

		System.out.println("successful");

	}

	/*
	 * @Test public void getPostXMLvalidation1() {
	 * 
	 * Response res = given()
	 * 
	 * .when().get("http://restapi.adequateshop.com/api/Traveler?page=6");
	 * 
	 * String pageNum =
	 * res.xmlPath().get("TravelerinformationResponse.page").toString();
	 * Assert.assertEquals(pageNum, "6");
	 * 
	 * }
	 */

	// APPROCH
	@Test(priority = 2)
	public void getAnother() {

		// here iam getting like so like xml jaxb like that iam added this dependencies
		// then it will be resolved

		/*
		 * dependency> <groupId>javax.xml.bind</groupId>
		 * <artifactId>jaxb-api</artifactId> <version>2.3.1</version> </dependency>
		 * <dependency> <groupId>org.glassfish.jaxb</groupId>
		 * <artifactId>jaxb-runtime</artifactId> <version>2.3.3</version> <!-- Replace
		 * with the latest version --> </dependency>
		 */

		Response res = given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=6");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		int pageNumber = res.xmlPath().getInt("TravelerinformationResponse.page");

		Assert.assertEquals(pageNumber, 6);

		String email = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[3].email");
		Assert.assertEquals(email, "saiguntur@gmail.com");

	}

	public void textXMLresponceBody() {

		Response resc = given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=6");

		XmlPath xml = new XmlPath(resc.asString());
		List<String> travellers = xml.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);

		// verify traveller detials r name is present in responce
		List<String> all = xml.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		for (String one : all) {
			if (one.equalsIgnoreCase("Developer")) {
				status = true;
			}
		}
		Assert.assertEquals(status, true);
		System.out.println("Successful");
	}

}
