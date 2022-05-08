import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * YTjson is a class written to hold all of the youtube json variables that are parsed from gson
 * This class contains multiple subclasses in order to be a container for the multi layered JSON response from youtube
 * The @SerializedName tags are the identifiers that correspond to json fields for gson to find when parsing
 */
public class YTjson{

	@SerializedName("regionCode")
	private String regionCode;

	@SerializedName("kind")
	private String kind;

	@SerializedName("nextPageToken")
	private String nextPageToken;

	@SerializedName("pageInfo")
	private PageInfo pageInfo;

	@SerializedName("etag")
	private String etag;

	@SerializedName("items")
	private List<ItemsItem> items;

	/**
	 * @return Region Code
	 */
	public String getRegionCode(){
		return regionCode;
	}

	/**
	 * @return Kind
	 */
	public String getKind(){
		return kind;
	}

	/**
	 * @return Next page token
	 */
	public String getNextPageToken(){
		return nextPageToken;
	}

	/**
	 * @return Page Info
	 */
	public PageInfo getPageInfo(){
		return pageInfo;
	}

	/**
	 * @return Etag
	 */
	public String getEtag(){
		return etag;
	}

	/**
	 * @return Items List
	 */
	public List<ItemsItem> getItems(){
		return items;
	}

	public class Id{

		@SerializedName("kind")
		private String kind;

		@SerializedName("videoId")
		private String videoId;

		/**
		 * @return Kind
		 */
		public String getKind(){
			return kind;
		}

		/**
		 * @return he video ID
		 */
		public String getVideoId(){
			return videoId;
		}
	}

	public class ItemsItem{

		@SerializedName("snippet")
		private Snippet snippet;

		@SerializedName("kind")
		private String kind;

		@SerializedName("etag")
		private String etag;

		@SerializedName("id")
		private Id id;

		/**
		 * @return The video snippet
		 */
		public Snippet getSnippet(){
			return snippet;
		}

		/**
		 * @return Kind
		 */
		public String getKind(){
			return kind;
		}

		/**
		 * @return The Etag
		 */
		public String getEtag(){
			return etag;
		}

		/**
		 * @return The ID
		 */
		public Id getId(){
			return id;
		}
	}
	
	public class JsonMemberDefault{

		@SerializedName("width")
		private int width;

		@SerializedName("url")
		private String url;

		@SerializedName("height")
		private int height;

		/**
		 * @return The thumbnail width
		 */
		public int getWidth(){
			return width;
		}

		/**
		 * @return The thumbnail URL
		 */
		public String getUrl(){
			return url;
		}

		/**
		 * @return The thumbnail height
		 */
		public int getHeight(){
			return height;
		}
	}

	public class High{

		@SerializedName("width")
		private int width;

		@SerializedName("url")
		private String url;

		@SerializedName("height")
		private int height;

		/**
		 * @return The thumbnail width
		 */
		public int getWidth(){
			return width;
		}
		/**
		 * @return The thumbnail URL
		 */
		public String getUrl(){
			return url;
		}
		/**
		 * @return The thumbnail height
		 */
		public int getHeight(){
			return height;
		}
	}

	public class Medium{

		@SerializedName("width")
		private int width;

		@SerializedName("url")
		private String url;

		@SerializedName("height")
		private int height;
		/**
		 * @return The thumbnail width
		 */
		public int getWidth(){
			return width;
		}
		/**
		 * @return The thumbnail URL
		 */
		public String getUrl(){
			return url;
		}
		/**
		 * @return The thumbnail height
		 */
		public int getHeight(){
			return height;
		}
	}

	public class Snippet{

		@SerializedName("publishTime")
		private String publishTime;

		@SerializedName("publishedAt")
		private String publishedAt;

		@SerializedName("description")
		private String description;

		@SerializedName("title")
		private String title;

		@SerializedName("thumbnails")
		private Thumbnails thumbnails;

		@SerializedName("channelId")
		private String channelId;

		@SerializedName("channelTitle")
		private String channelTitle;

		@SerializedName("liveBroadcastContent")
		private String liveBroadcastContent;

		/**
		 * @return The publish time
		 */
		public String getPublishTime(){
			return publishTime;
		}
		/**
		 * @return Published at
		 */
		public String getPublishedAt(){
			return publishedAt;
		}
		/**
		 * @return The description
		 */
		public String getDescription(){
			return description;
		}
		/**
		 * @return The title
		 */
		public String getTitle(){
			return title;
		}
		/**
		 * @return Thumbnails
		 */
		public Thumbnails getThumbnails(){
			return thumbnails;
		}
		/**
		 * @return The channel ID
		 */
		public String getChannelId(){
			return channelId;
		}
		/**
		 * @return The channel title
		 */
		public String getChannelTitle(){
			return channelTitle;
		}
		/**
		 * @return the Live Broadcast Content
		 */
		public String getLiveBroadcastContent(){
			return liveBroadcastContent;
		}
	}

	public class Thumbnails{

		@SerializedName("default")
		private JsonMemberDefault jsonMemberDefault;

		@SerializedName("high")
		private High high;

		@SerializedName("medium")
		private Medium medium;

		/**
		 * @return Default thumbnail quality class
		 */
		public JsonMemberDefault getJsonMemberDefault(){
			return jsonMemberDefault;
		}
		/**
		 * @return High thumbnail quality class
		 */
		public High getHigh(){
			return high;
		}
		/**
		 * @return Medium thumbnail quality class
		 */
		public Medium getMedium(){
			return medium;
		}
	}

	public class PageInfo{

		@SerializedName("totalResults")
		private int totalResults;

		@SerializedName("resultsPerPage")
		private int resultsPerPage;
		/**
		 * @return Total results
		 */
		public int getTotalResults(){
			return totalResults;
		}
		/**
		 * @return Results per page
		 */
		public int getResultsPerPage(){
			return resultsPerPage;
		}
	}


}
