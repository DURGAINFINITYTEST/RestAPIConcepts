package com.allapis;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FileUploadTest {

	@Test
	public void downFile() {
		RestAssured.given()

				.when().get("http://your-api-endpoint.com/upload").then().statusCode(200);

	}

	@Test
	public void uploadSingleFile() {
		File fileToUpload = new File("C:\\Users\\katak\\OneDrive\\Documents\\st.txt");

		RestAssured.given().multiPart("file", fileToUpload).contentType("multipart/form-data")// "file" should match the
																								// parameter name
																								// expected by the
																								// API
				.when().post("http://your-api-endpoint.com/upload")

				// Replace with the actual API endpoint
				.then().statusCode(200).log().all();// Replace with the expected status code after successful upload
	}

	@Test
	public void uploadMultiFile() {
		File fileToUpload = new File("C:\\Users\\katak\\OneDrive\\Documents\\st.txt");
		File fileToUpload1 = new File("C:\\Users\\katak\\OneDrive\\Documents\\st.txt");

		RestAssured.given().multiPart("file", fileToUpload).multiPart("file", fileToUpload1)
				.contentType("multipart/form-data")// "file" should match the parameter name expected by the
													// API
				.when().post("http://your-api-endpoint.com/upload")

				// Replace with the actual API endpoint
				.then().statusCode(200).log().all();// Replace with the expected status code after successful upload
	}

}