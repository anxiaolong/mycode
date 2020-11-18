package java_12_zj_fs_zjm_ljz;
/**
 * 测试使用脚本引擎，执行JavaScript脚本
 */
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Dtby_test02 {
	public static void main(String[] args) throws Exception {
		//获得脚本引擎
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		//定义变量
		engine.put("msg", "test java_script");
		String str = "var user = {name:'anxiaolong',age:27,school:['北京大学','成都大学']};";
		str += "print(user.name);";
		//执行脚本
		engine.eval(str);
		engine.eval("msg='java is very good';");
		System.out.println(engine.get("msg"));
		System.out.println("########分界线#############");
		
		//定义函数
		engine.eval("function add(a,b) {var sum=a+b;return sum;}");
		//取得调用接口
		Invocable jsInvoc = (Invocable)engine;
		//执行脚本中定义的方法
		Object result1 = jsInvoc.invokeFunction("add", new Object[] {22,23});
		System.out.println(result1);
		
		//导入其他java包，并使用其中的java类
		String jsCode = "var list = java.util.Arrays.asList([\"北大\",\"清华\",\"成大\"]);";
		engine.eval(jsCode);
		List<String> list1 = (List<String>)engine.get("list");
		for (String string : list1) {
			System.out.println(string);
		}
		
		//执行一个js文件
		 URL is = new URL("file:/D:/eclipse-workspace/mycode/src/zj_fs_zjm_ljz/Dtby.js");
		System.out.println(is);
		Reader r = new FileReader(is.getPath());
		engine.eval(r);
	}
}



