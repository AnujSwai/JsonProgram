import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.internal.support.FileReader;

public class TestUsingJSON {


	public String[] readJson() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader=new FileReader("./jsonfiles//RCB.json");     
		
		Object obj=jsonParser.parse(reader);
		JSONObject userloginJsonobj=(JSONObject) obj;
		JSONArray playerloginArray=(JSONArray) userloginJsonobj.get("player");
		
		String arr[]=new String[playerloginArray.size()];
		
		for(int i=0;i<playerloginArray.size();i++)
		{
		
		   JsonObject users=(JsonObject) playerloginArray.get(i);
		   
		   JsonValue Name=users.get("name");
		   char myJSON = JSON.stringify("Name");
		   JsonValue Country=users.get("country");
		   JsonValue Role=users.get("role");
		   JsonValue Price=users.get("price-in-crores");
		   
		   arr[i]=Name+","+Country+","+Role+","+Price;
		   System.out.print(arr);
		  
		}
		return arr;
	
}
