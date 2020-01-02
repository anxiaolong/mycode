package api_test;
/**
 * 测试fastjson创建json对象和解析json对象
 */
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TestFastJson {
	//创建json对象
	public static JSONObject creatJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "anxiaolong");
		jsonObject.put("age", 27);
		jsonObject.put("job", "test");
		jsonObject.put("sex", 1);
		List<String> list = Arrays.asList("dfdf","fdfd","oooo","fdffff");
		jsonObject.put("infos", list);
		jsonObject.put("null", "null");
		jsonObject.put("boolean", true);
//		System.out.println(jsonObject);
		return jsonObject;
	}
	
	//解析json对象
	public static void parseJsonObject() {
		System.out.println(creatJsonObject().toString());
		String jsonString = creatJsonObject().toString();
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		System.out.println(jsonObject.get("boolean"));
		System.out.println(jsonObject.get("null"));
		System.out.println(jsonObject.get("sex"));
		System.out.println(jsonObject.get("name"));
		System.out.println(jsonObject.get("job"));
		System.out.println(jsonObject.get("age"));
		System.out.println(jsonObject.get("infos"));
		List<String> list = (List<String>) jsonObject.get("infos");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	public static void main(String[] args) {
		parseJsonObject();
	}
}	
