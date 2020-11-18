package java_12_zj_fs_zjm_ljz;
/**
 * ����ʹ�ýű����棬ִ��JavaScript�ű�
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
		//��ýű�����
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		//�������
		engine.put("msg", "test java_script");
		String str = "var user = {name:'anxiaolong',age:27,school:['������ѧ','�ɶ���ѧ']};";
		str += "print(user.name);";
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg='java is very good';");
		System.out.println(engine.get("msg"));
		System.out.println("########�ֽ���#############");
		
		//���庯��
		engine.eval("function add(a,b) {var sum=a+b;return sum;}");
		//ȡ�õ��ýӿ�
		Invocable jsInvoc = (Invocable)engine;
		//ִ�нű��ж���ķ���
		Object result1 = jsInvoc.invokeFunction("add", new Object[] {22,23});
		System.out.println(result1);
		
		//��������java������ʹ�����е�java��
		String jsCode = "var list = java.util.Arrays.asList([\"����\",\"�廪\",\"�ɴ�\"]);";
		engine.eval(jsCode);
		List<String> list1 = (List<String>)engine.get("list");
		for (String string : list1) {
			System.out.println(string);
		}
		
		//ִ��һ��js�ļ�
		 URL is = new URL("file:/D:/eclipse-workspace/mycode/src/zj_fs_zjm_ljz/Dtby.js");
		System.out.println(is);
		Reader r = new FileReader(is.getPath());
		engine.eval(r);
	}
}



