package api_test;

import java.io.IOException;
import java.util.Set;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class SerchSongByName_SerchSongByName {
	//��ȡ��������ķ���
	public static String getSongbyKey(String key) throws IOException {
		Connection conn = Jsoup.connect("https://open.migu.cn:98/sportMusic/rest/search/voiceBoxSearchSong?evident")
				.method(Method.POST).ignoreContentType(true)
				.header("Authorization", "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"")
				.header("Content-Type", "application/json")
				.requestBody("{ \r\n" + 
						" \"text\":\""+key+"\",\r\n" + 
						" \"matchType\":\"0\",\r\n" + 
						" \"searchType\":\"4\",\r\n" + 
						" \"sort\":\"0\",\r\n" + 
						" \"issemantic\":\"0\",\r\n" + 
						" \"isCorrect\":\"0\",\r\n" + 
						" \"isCopyright\":\"1\",\r\n" + 
						" \"expire\":\"111111\",\r\n" + 
						" \"sortType\":\"1\",\r\n" + 
						" \"searchRange\": {\"songName\":[\""+key+"\"]}\r\n" + 
						"}");
		Response rsp = conn.execute();
		return rsp.body();
	}

	public static void main(String[] args) throws Exception {
			//���ݿ��л�ȡҪ�����ĸ�����
			Set<String> allSet = SerchSongByName_jdbc.Allid();
			
			for (String id : allSet) {//��һ�㣬�������еĸ���
				String resutlString = getSongbyKey(id);				
				StringBuffer sb = new StringBuffer();
				
				JSONObject jsonObject = JSONObject.parseObject(resutlString);
				jsonObject = JSONObject.parseObject(jsonObject.get("searchVoiceBoxS").toString());
				jsonObject = JSONObject.parseObject(jsonObject.get("data").toString());
				JSONArray jsonArray = JSONArray.parseArray(jsonObject.get("result").toString());
				for (int i = 0; i < jsonArray.size(); i++) {//�ڶ��㣬����result��������ݣ�result��һ��JSONArray
					JSONArray jsonArray2 = JSONArray.parseArray(jsonArray.getJSONArray(i).toString());
					for (int j = 0; j < jsonArray2.size(); j++) {//�����㣬����jsonArray2���������
						sb = sb.append(jsonArray2.getJSONObject(j).get("name")+";");
						
						JSONArray jsonArray3 = JSONArray.parseArray(jsonArray2.getJSONObject(j).get("fullSongs").toString());
						System.out.println(jsonArray3);
						for (int k = 0; k < jsonArray3.size(); k++) {//���Ĳ㣬����jsonArray3���������
							sb = sb.append(jsonArray3.getJSONObject(k).get("copyrightId")+";");
						}
					}
				}
				SerchSongByName_jdbc.write2Db(id, sb.toString());//д��
			}
	}
	
}
