package com.api.testing.junit.postsdetails;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;


@RunWith(SerenityRunner.class)
public class GetPostsTest {
	
	@BeforeClass
	public static void init()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
	}
	
	
	public void getAllPosts()
	{
		SerenityRest.given()
		.when()
		.get()
		.then()
		.log()
		.all()
		.statusCode(200);
	}

	
}
