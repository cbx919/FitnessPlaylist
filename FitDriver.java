import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FitDriver {

	public static void main(String[] args) {
		
		new FitGUI();	//call the GUI stored in FitGUI.java
		//GUI prompt: user clicks Get Started button, goes to next panel asking
		//which exercise they will be focusing on today with drop down menu option selection
		//--do we need all possible ddm option selections stored in a container/arrayList?
		//String object created from selection using method below (should be in GUI class)
		//String object becomes query to API class method once passed
		//majority, if not all, of this program can be ran through GUI class/prompts
		//need to work on output possibilities -- embedding videos in final panel?
		//but should test output through console first: 
		
		System.out.println(youtubeAPI);
		//String obj ran through Youtube Data API as search query should return in JSON
		//do we parse JSON with a parsing library or try to have the GUI 
		//display API class output as URLs or embedded videos?
		
		//https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionListener.html
		public void actionPerformed(ActionEvent e) {	//Performed vs Listener? Event handler
			JComboBox<Item> comboBox = (JComboBox<Item>) e.getSource();
			Item item1 = (Item) comboBox.getSelectedItem();
			
		//String object created from GUI class combo box selection needs to be passed
		//to API class/ API method...have API method call that String object
		//refer to setQ(String obj);
		//
		//

	}

}
	
	
	
	YouTube.Search.List search = youtube.search().list("id,snippet");
	String apiKey = properties.getProperty("youtube.apikey");
	search.setKey(apiKey);
	//Method to set query
	search.setQ(queryTerm);


	// Call the API and print results.
	public static JSONObject jsonObject = null;
	public static Properties properties = null;
	SearchListResponse searchResponse = search.execute();
	List<SearchResult> searchResultList = searchResponse.getItems();
	 if (searchResultList != null) {
	    prettyPrint(searchResultList.iterator(), queryTerm);
	 }

