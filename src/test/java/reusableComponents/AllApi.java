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
		String[] featuredQuestList = new String[4];
		int i;
		for(i=0;i<4;i++) {
			featuredQuestList[i]=jsonPath.getString("data.quests["+i+"].quest_title");
		}	
		for(int j=0;j<4;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Featured Quest "+(j+1)+": "+ featuredQuestList[j]);
	    }
		return featuredQuestList;
	}
	
	public static String[] getFeaturedGames() throws Exception {
		Response response = RestAssured.get("https://stage-api-backend.kgen.io/game/filter?gameCategories=Editor's Choice");
		Assert.assertEquals(response.getStatusCode(), 200);
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String[] featuredGameList = new String[4];
		int i;
		for(i=0;i<4;i++) {
			featuredGameList[i]=jsonPath.getString("games["+i+"].game.name");
		}	
		for(int j=0;j<4;j++) {
	    	ExtentTestFactory.getInstance().getExtentTest().info("API RESPONSE --> Featured Game "+(j+1)+": "+ featuredGameList[j]);
	    }
		return featuredGameList;
	}
	
	
	
	
	
	
	
	
}

