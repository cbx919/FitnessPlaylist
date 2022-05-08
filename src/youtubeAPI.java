
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.*;


/**
 * A youtube API querying class
 * Queries youtube API and receives request, parses json and returns relevant items
 */

public class youtubeAPI {
    private final String API_KEY;
    private final String API_URL;
    private final String ytWatchURL;
    private String fullURL;

    /**
     * youtubeAPI constructor
     *
     */

   public youtubeAPI(){
       this.API_KEY = "AIzaSyDTn6-P20k3Pc2ECngAm1oZ8Q7UWDh6ZZg";
       this.API_URL = "https://www.googleapis.com/youtube/v3";
       this.ytWatchURL = "https://www.youtube.com/watch?v=";

   }

    /**
     * Method to form API queries and call the y
     * @param query The search query of the videos
     * @return youtube video link in a String
     */
   public String videoSearch(String query){
       if (query.contains(" ")){
           query = query.replace(" ", "+");
       }

       this.urlFormer("search", new String[]{query});

       return ytWatchURL + (String) gsonUrlConn();
   }


    /**
     *
     * @param queryType The type of query - See youtube API docs for query types Ex. search
     * @param queries The web queries to be added to the URL
     * @return The full URL in string form
     *
     */

    private void urlFormer(String queryType, String[] queries) {

        String relativeURL = "/" + queryType + "?" + "key=" + this.API_KEY + "&" + "q=";
        for (int i = 0; i < queries.length; i++) {

            relativeURL =  relativeURL.concat(queries[i]);
            if (i < queries.length -1){
                relativeURL = relativeURL.concat("&");
            }
        }

        this.fullURL = API_URL.concat(relativeURL);

    }

    /**
     * HTTP connection and inputstream parser to JSON object
     * Takes the JSON from an inputstream from youtube and parses into an instance of the YTjson class
     * @return Parsed JSON object
     *
     */
    private Object gsonUrlConn(){
        String x = null;
        try {
            URL testUrl = new URL(fullURL);
            URLConnection urlConnection = (HttpsURLConnection)testUrl.openConnection();
            InputStream stream = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

            YTjson jsonObject = new Gson().fromJson(reader, YTjson.class);

            x = jsonObject.getItems().get(0).getId().getVideoId();

        }
        catch (Exception e){
            return e;
        }
        return x;
    }


}


/*
 ****** Notes on url queries *********
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