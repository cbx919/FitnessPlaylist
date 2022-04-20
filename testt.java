
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//advised to look into API wrappers
//example reference: https://github.com/Bumbleboss/youtube_api (4 yrs old)
//another reference to further Chris' idea:
//https://stackoverflow.com/questions/21720759/convert-a-json-string-to-a-hashmap
public class testt {

	public static void main(String[] args) {
		/*
		youtubeAPI2 myAPI = new youtubeAPI2();
		Object JSONobj = myAPI.urlConn();		//same as line 26
	
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		
		//https://stackoverflow.com/questions/36244619/cant-resolve-fromjson
		Gson gson = gb.create();
		URL url = gson.fromJson(JSONobj, URL.class);	//ClassCastException when JSONobj casted as String
		System.out.println("videoId:" +(JSONobj).getVidId());
	}
}
		
		//new jComboBox(); -- can't call because is inside own main method
		//new Checkbox();
		
		class URL{
			protected String videoId;
			protected void videoId() {}
		
			public String getVidId() {
				return videoId;
		}
			public void setVidId(String videoId) {
				this.videoId = videoId;
		}
			public String toString() {
				return "youtube.com/watch?v=" + videoId;
		}
			*/

			
		//example output displaying every kind of String property to a Youtube video
		//need to pull videoId in our case - see line 34
		//doesn't return as a file though
		youtubeAPI2 myAPI = new youtubeAPI2();
		
		Object JSONobj = myAPI.urlConn();
		JSONObject jsonObject = (JSONObject) JSONobj;
		
		System.out.println(jsonObject);
		
		/*//ref:https://stackoverflow.com/questions/55466807/trying-to-extract-video-id-from-json-using-youtube-api
		 * 
		 * trying to access nested Strings in JSON output - test line 57 to see subStrings in Strings/hierarchy
		 * 												  - may be hard to read without pretty printing
		 * 
	    JSONArray jArr = JSONObject.getJSONArray("items");
	    for(int i =0; i < jArr.length(); i++)
	    {
	        // getting object from items array 
	        JSONObject itemObj = jArr.getJSONObject(i);

	        // getting id object from item object 
	        JSONObject idObj = itemObj.getJSONObject("id");

	        // getting videoId from idObject 
	        String videoId = idObj.getString("videoId"); 
	    }*/
	
	}
}



