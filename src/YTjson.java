import com.google.gson.annotations.SerializedName;
import java.util.List;

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

	public String getRegionCode(){
		return regionCode;
	}

	public String getKind(){
		return kind;
	}

	public String getNextPageToken(){
		return nextPageToken;
	}

	public PageInfo getPageInfo(){
		return pageInfo;
	}

	public String getEtag(){
		return etag;
	}

	public List<ItemsItem> getItems(){
		return items;
	}


	public class Id{

		@SerializedName("kind")
		private String kind;

		@SerializedName("videoId")
		private String videoId;

		public String getKind(){
			return kind;
		}

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

		public Snippet getSnippet(){
			return snippet;
		}

		public String getKind(){
			return kind;
		}

		public String getEtag(){
			return etag;
		}

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

		public int getWidth(){
			return width;
		}

		public String getUrl(){
			return url;
		}

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

		public int getWidth(){
			return width;
		}

		public String getUrl(){
			return url;
		}

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

		public int getWidth(){
			return width;
		}

		public String getUrl(){
			return url;
		}

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

		public String getPublishTime(){
			return publishTime;
		}

		public String getPublishedAt(){
			return publishedAt;
		}

		public String getDescription(){
			return description;
		}

		public String getTitle(){
			return title;
		}

		public Thumbnails getThumbnails(){
			return thumbnails;
		}

		public String getChannelId(){
			return channelId;
		}

		public String getChannelTitle(){
			return channelTitle;
		}

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

		public JsonMemberDefault getJsonMemberDefault(){
			return jsonMemberDefault;
		}

		public High getHigh(){
			return high;
		}

		public Medium getMedium(){
			return medium;
		}
	}

	public class PageInfo{

		@SerializedName("totalResults")
		private int totalResults;

		@SerializedName("resultsPerPage")
		private int resultsPerPage;

		public int getTotalResults(){
			return totalResults;
		}

		public int getResultsPerPage(){
			return resultsPerPage;
		}
	}


}
