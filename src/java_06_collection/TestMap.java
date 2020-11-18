package java_06_collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 测试Map接口和其实现类HashMap
 * @author Administrator
 *
 */
public class TestMap {
	public static void main(String[] args) {
		//HashMap: 线程不安全，效率高。允许key或value为null
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		m2.put(1, "一");
		m2.put(2, "二");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.size());//m1的长度
		System.out.println(m1.containsKey(2));//m1是否包含键值2
		System.out.println(m2.containsValue("二"));//m2是否包含二这个value值
		m1.put(3, "anxiaolong");//已存在的键值对，覆盖之前
		Map<Integer, String> m3 = new HashMap<Integer, String>();
		m3.putAll(m1);
		m3.putAll(m2);//键值对加入到m3中，相同key值对应的值更换为m2的
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		//HashTable: 线程安全，效率低。不允许key或value为null
		Map<Integer, String> m4 = new Hashtable<Integer, String>();
	}
}
