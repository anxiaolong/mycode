package java_apply01_api_test;
/**
 * 测试fastjson常用方法
 */
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestFastJson {
	public int id;
	public String name;
	public String pwd;
	public static TestFastJson tfj=new TestFastJson(11, "anxiaolong", "123456");
	
	@Override
	public String toString() {
		return "TestFastJson [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	public TestFastJson(int id,String name,String pwd) {
		this.id=id;
		this.name=name;
		this.pwd=pwd;
	}
	
	//1.Java对象转json字符串
	public static void pojo2JsonString() {
		System.out.println(JSON.toJSONString(tfj));
	}
	//2.Java对象转Json对象
	public static void pojo2JsonObj() {
		System.out.println(JSONObject.toJSON(tfj));
	}
	//3.json对象转json字符串
	public static void jsonObj2JsonStr() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", "11");
		jsonObject.put("name", "tetttt");
		jsonObject.put("pwd", "111111");
		System.out.println(jsonObject.toJSONString());
	}
	//4.json对象转java对象
	public static void jsonObj2JavaObj() {
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", 11);
		jsonObject.put("name", "tetttt");
		jsonObject.put("pwd", "111111");
		System.out.println(JSON.toJavaObject(jsonObject, TestFastJson.class));
	}
	//5.json字符串装json对象
	public static void jsonStr2JsonObj() {
		String string= "{\"id\":11,\"name\":\"andd\",\"pwd\":\"111111\"}";
		JSONObject jsonObject=JSON.parseObject(string);
		System.out.println(jsonObject);
	}
	//6.json字符串转java对象
	public static void jsonStr2JavaObj() {
		String string= "{\"id\":11,\"name\":\"andd\",\"pwd\":\"111111\"}";
		TestFastJson ttt = JSON.parseObject(string, TestFastJson.class);
		System.out.println(ttt);
	}
	
	public static void main(String[] args) {
		pojo2JsonString();
		pojo2JsonObj();
		jsonObj2JsonStr();
		jsonObj2JavaObj();
		jsonStr2JsonObj();
		jsonStr2JavaObj();
		List<TestFastJson> list=new ArrayList<TestFastJson>();
		list.add(new TestFastJson(1, "dddd", "111111"));
		list.add(new TestFastJson(2, "anxiaolong", "333333"));
		list.add(new TestFastJson(3, "liudeeee", "44455664"));
		System.out.println(JSON.toJSONString(list));
	}
}	
