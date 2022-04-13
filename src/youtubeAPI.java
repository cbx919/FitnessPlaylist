
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.net.ssl.HttpsURLConnection;

/**
 * A youtube API querying class
 * Querys youtube API and receives request, parses json and returns relevant items
 */

public class youtubeAPI {
    private final String API_KEY;
    private final String API_URL;
    private String fullURL;


   public youtubeAPI(){
       this.API_KEY = "AIzaSyDTn6-P20k3Pc2ECngAm1oZ8Q7UWDh6ZZg";
       this.API_URL = "https://www.googleapis.com/youtube/v3";
   }

    /**
     *
     * @param numberOfVideos The number of videos to be returned in a search
     * @param query The search query of the videos
     * TODO - Create full routine after getting urlConn routine working
     */
   public String videoSearch(int numberOfVideos, String query){
        //Need to create after the getting the https URL connection and the JSON parser working
    return "null";
   }


    /**
     *
     * @param queryType The type of query - See youtube API docs for query types Ex. search
     * @param queries The web queries to be added to the URL
     * @return The full URL in string form
     * TODO - Integrate this with urlConn routine
     */
    private String UrlFormer(String queryType, String[] queries) {

        String relativeURL = "/" + queryType + "?" + "key=" + this.API_KEY + "&";
        for (int i = 0; i < queries.length; i++) {

            relativeURL =  relativeURL.concat(queries[i]);
            if (i < queries.length -1){
                relativeURL = relativeURL.concat("&");
            }
        }

        return this.fullURL = fullURL.concat(relativeURL);

    }

    /**
     * WIP HTTPs connection and inputstream parser to JSON object
     * The web request works
     * TODO - figure out why this throws a parse exception
     * @return Parsed JSON object
     *
     */
    public Object urlConn(){
        JSONObject testWebContent;
       try {
           URL testUrl = new URL("https://www.googleapis.com/youtube/v3/search?key=AIzaSyDTn6-P20k3Pc2ECngAm1oZ8Q7UWDh6ZZg&type=video&q=triceps+workout&part=snippet");

            try {
               HttpsURLConnection urlConnection = (HttpsURLConnection)testUrl.openConnection();
               InputStream stream = urlConnection.getInputStream();
               InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
               JSONParser parser = new JSONParser();
               try {
                   testWebContent = (JSONObject) parser.parse(reader);

               }
               catch (ParseException pe){
                   return "ParseException";
               }
               //InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
                // testWebContent = reader.read();


            }
            catch(IOException f){
               return "IOexception";
           }
       }
       catch(MalformedURLException e){
           return "Malformed URL";
        }
       
        return testWebContent;

    }

}


/*
 ****** Notes on url querys *********
 * Base url for api is necessary plus api key
 *
 * Any additional method calls or parameters that are sent come after a "?"
 *   Ex: https://googleapis.com/youtube/v3/search?key=xyz
 * To tack on parameters after the first parameter, a "&" is used
 *   Ex: https://googleapis.com/youtube/v3/search?key=xyz&type=video
 * If a video has been found in the api and you want to play it, use the videoID field to play it
 *   Ex: https://www.youtube.com/watch?v=dQw4w9WgXcQ
 * If a space needs to be in a parameter value, use "+"
 *
 */