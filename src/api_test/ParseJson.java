package api_test;

/*
 * ����Ƕ�׵�json����ʾ��������jsonObjcet��jsonArray������������
 * 
 * ʵ�����ݣ�
 * {
    "searchVoiceBoxS": {
        "data": {
            "total": 1,
            "result": [
                [
                    {
                        "id": "1130129164",
                        "name": "·��(3D Audio)",
                        "highlightStr": "·��",
                        "singers": [
                            {
                                "id": "311",
                                "name": "�̽���"
                            }
                        ],
                        "albums": [],
                        "lyricUrl": "http://218.200.230.40:18089/files/lyric/2020-02-23/61a5e14c9207437ea5388c6df4c92c20.lrc",
                        "copyright": "1",
                        "fullSongs": [
                            {
                                "id": "600913000008583151",
                                "copyrightId": "6005752C5A4",
                                "price": "200",
                                "expireDate": "2099-12-31"
                            }
                        ]
                    }
                ]
            ],
            "resultType": 2,
            "isFromCache": 0,
            "fullSongTotal": 1
        }
    },
    "resCode": "000000",
    "resMsg": "��OPEN�������ɹ�"
}
 */

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class ParseJson {
	
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
	
	public static void main(String[] args) throws IOException {
		//1.��ȡ�ӿڷ��ص�Ƕ��json����
		String jsonString = getSongbyKey("·�� (3D Audio)");
		System.out.println(jsonString);
		
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		jsonObject = JSONObject.parseObject(jsonObject.get("searchVoiceBoxS").toString());
		jsonObject = JSONObject.parseObject(jsonObject.get("data").toString());
		JSONArray jsonArray = JSONArray.parseArray(jsonObject.get("result").toString());
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONArray jsonArray2 = JSONArray.parseArray(jsonArray.getJSONArray(i).toString());
			for (int j = 0; j < jsonArray2.size(); j++) {
				//��������
				System.out.println(jsonArray2.getJSONObject(j).get("name"));
				//��һ������fullSongs��Ӧ��jsonArray
				JSONArray jsonArray3 = JSONArray.parseArray(jsonArray2.getJSONObject(j).get("fullSongs").toString());
				for (int k = 0; k < jsonArray3.size(); k++) {
					//��ø�����copyrightId
					System.out.println(jsonArray3.getJSONObject(k).get("copyrightId"));
					System.out.println(jsonArray3.getJSONObject(k).get("price"));
					System.out.println(jsonArray3.getJSONObject(k).get("expireDate"));
					System.out.println(jsonArray3.getJSONObject(k).get("id"));
				}
			}
		}
	}
}
