package reusableComponents;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testBase.ExtentTestFactory;

public class AllApi {
	
//	public static JsonPath getLiveQuests() throws Exception {
//		Response response = RestAssured.get("https://prod-api-backend.kgen.io/quest/v2/questlist?questCategories=FEATURED");
//		Assert.assertEquals(response.getStatusCode(), 200);
//		String responseBody = response.getBody().asString();
//		JsonPath jsonPath = new JsonPath(responseBody);
//		return jsonPath;
//	}
//	
//	public String[] getFeaturedQuests() throws Exception {
//		JsonPath jsonPath = getLiveQuests();
//		int count=0;
//		int i=0;
//		String[] featuredQuestList = new String[5];
//		//goes never ending if featured < 5 modify this 
//		while(count<5) {
//			String questState = jsonPath.getString("data.quests["+i+"].quest_state");
//			if(questState.equals("Live")) {
//				featuredQuestList[count]=jsonPath.getString("data.quests["+i+"].quest_title");
//				count++;
//			}
//			i++;
//		}
//		//log in report
//	    for(int j=0;j<5;j++) {
//	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Featured Quest "+(j+1)+": "+ featuredQuestList[j]);
//	    }
//	    return featuredQuestList;
//	}
	
	public static String[] getFeaturedQuests() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/quest/v2/questlist?geoGraphy=INDIA&questCategories=FEATURED&questState[]=LIVE&page=1&limit=4");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String[] featuredQuestsList = new String[4];
		int i;
		for(i=0;i<4;i++) {
			featuredQuestsList[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<4;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Featured Quest "+(j+1)+": "+ featuredQuestsList[j]);
	    }
		return featuredQuestsList;
	}
	
	public static String[] getFeaturedGames() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/game/filter?gameCategories=Editor's Choice");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String[] featuredGamesList = new String[4];
		int i;
		for(i=0;i<4;i++) {
			featuredGamesList[i]=jsonPath.getString("games["+i+"].game.name");
		}	
		for(int j=0;j<4;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Featured Game "+(j+1)+": "+ featuredGamesList[j]);
	    }
		return featuredGamesList;
	}
	
	public static String[] getTrendingNowGames() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/game/filter?gameCategories=New & Noteworthy");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String[] trendingGamesList = new String[15];
		int i;
		for(i=0;i<15;i++) {
			trendingGamesList[i]=jsonPath.getString("games["+i+"].game.name");
		}	
		for(int j=0;j<15;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Trending Game "+(j+1)+": "+ trendingGamesList[j]);
	    }
		return trendingGamesList;
	}
	
	public static String[] getAllQuests() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/quest/v2/questlist?geoGraphy=INDIA");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int count = jsonPath.getInt("data.totalCount");
		String[] allQuests = new String[count];
		int i;
		for(i=0;i<count;i++) {
			allQuests[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<count;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Quest "+(j+1)+": "+ allQuests[j]);
	    }
		return allQuests;
	}
	
	
		
	public static String[] getLiveQuests() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/quest/v2/questlist?geoGraphy=INDIA&questState=LIVE");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int count = jsonPath.getInt("data.totalCount");
		String[] allLiveQuests = new String[count];
		int i;
		for(i=0;i<count;i++) {
			allLiveQuests[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<count;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Live Quest "+(j+1)+": "+ allLiveQuests[j]);
	    }
		return allLiveQuests;
	}
	
	public static String[] getUpcomingQuests() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/quest/v2/questlist?geoGraphy=INDIA&questState=PUBLISHED");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int count = jsonPath.getInt("data.totalCount");
		String[] allUpcomingQuests = new String[count];
		if(count==0) {
			return allUpcomingQuests;
		}
		else {
		int i;
		for(i=0;i<count;i++) {
			allUpcomingQuests[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<count;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Upcoming Quest "+(j+1)+": "+ allUpcomingQuests[j]);
	    }
		return allUpcomingQuests;
		}
	}
	
	public static String[] getEndedQuests() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/quest/v2/questlist?geoGraphy=INDIA&questState=ENDED");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		int count = jsonPath.getInt("data.totalCount");
		String[] allEndedQuests = new String[count];
		if(count==0) {
			return allEndedQuests;
		}
		else {
		int i;
		for(i=0;i<count;i++) {
			allEndedQuests[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<count;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Ended Quest "+(j+1)+": "+ allEndedQuests[j]);
	    }
		return allEndedQuests;
		}
	}
		
	
	
}

