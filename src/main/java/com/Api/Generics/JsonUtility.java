package com.Api.Generics;

import io.restassured.response.Response;

public class JsonUtility {
	
	 public String getJsonPathData(String jsonXpath, Response resp)
	 {
		   String result = resp.jsonPath().get(jsonXpath);
		return result;
		   
	 }
}