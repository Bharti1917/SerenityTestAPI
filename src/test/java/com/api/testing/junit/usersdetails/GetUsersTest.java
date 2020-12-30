package com.api.testing.junit.usersdetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.api.testing.cucumber.serenity.UserSerenitySteps;
import com.api.testing.model.Users;
import com.api.testing.testbase.TestBase;
import com.api.testing.utils.ReusableSpecifications;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.UseTestDataFrom;


@UseTestDataFrom("testData\\userinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetUsersTest extends TestBase {
	
	 //creating instance of UserSerenitySteps class
		@Steps
		UserSerenitySteps steps;
		
	 //creating instance of Users class
		// Users user = new Users();
	     private String username;
         
	    
	
	public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}
	@WithTags(
			{
	@WithTag("usersfeature:SMOKE"),
	@WithTag("usersfeature:POSITIVE")
			}
	)
	@Title("This will validate the response code 200 of get users API")
	@Test
	public void verifyIftheStatusCodeIs200()
	{
		
		steps.getUser(username)
		.statusCode(200)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}

	@WithTags(
			{
	@WithTag("usersfeature:SMOKE"),
	@WithTag("usersfeature:POSITIVE")
			}
	)
	@Title("This will validate the response code  500 of get users API")
	@Test
	public void verifyIftheStatusCodeIsNot200()
	{
		
		steps.getUser(username)
		.statusCode(500)
		.spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	
	@WithTags(
			{
	@WithTag("usersfeature:INTEGRATION"),
	@WithTag("usersfeature:POSITIVE")
			}
	)
	@Title("This will get the details of user having username as per requirement")
	@Test
	   public void getUserDetails()
	   {   
		
		//user.setUsername("Delphine");
		//username=user.getUsername();
	    HashMap<String,Object> userDetails= steps.getUserDetailsByUsername(username);
		 
		
		System.out.println(userDetails);
		  assertThat(userDetails,hasValue(username));
		  
		  //extracting userId from hash map
		  int userId= (int) userDetails.get("id");
		  System.out.println(userId);
		  
		 		  
		   

	   }
	
	
}
