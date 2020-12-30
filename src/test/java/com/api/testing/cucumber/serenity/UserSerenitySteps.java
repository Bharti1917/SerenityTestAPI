package com.api.testing.cucumber.serenity;

import java.util.HashMap;

import com.api.testing.utils.ReusableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {
	
	@Step("Validating status code of get users API with username:{0}")
	public ValidatableResponse getUser(String username)
	{
		
		return SerenityRest
			 	.rest()
				.given()
				.queryParam("username", username)
				.when()
				.get("/users")
				.then();
		
	}
	
	@Step("Getting the user information with username:{0} ")
	public HashMap<String,Object> getUserDetailsByUsername(String username)
	{
		 String p1="findAll{it.username=='";
	     String p2= "'}.get(0)";
	     
		return SerenityRest
			 	.rest()
				.given()
				.queryParam("username", username)
				.when()
				.get("/users")
				.then()
				.spec(ReusableSpecifications.getGenericResponseSpec())
				.log()
				.all()
				.extract()
				.path(p1+username+p2);
		
	}

}
