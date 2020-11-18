package java_06_collection;
/**
 * 测试list转map map转list 
 * list中排序,list中对象实现Comparable接口
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestZuoye3 {
	//list转map,并遍历map
	public static void listToMap() {
		TestZuoye31 obj = new TestZuoye31(1001, 27, "anxiaolong", Sex.values()[0]);
		TestZuoye31 obj2 = new TestZuoye31(1003, 17, "ereref", Sex.values()[1]);
		TestZuoye31 obj3 = new TestZuoye31(1009, 34, "ttvv", Sex.values()[1]);
		List<TestZuoye31> l1List = new ArrayList<TestZuoye31>();
		l1List.add(obj);
		l1List.add(obj2);
		l1List.add(obj3);
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		m1Map.put(obj.id, obj.toString());
		m1Map.put(obj2.id, obj2.toString());
		m1Map.put(obj3.id, obj3.toString());
//		//使用entrySet方法，再遍历
//		Set<Entry<Integer, String>> t1Maps = m1Map.entrySet();
//		for (Iterator<Entry<Integer, String>> t1Iterator = t1Maps.iterator();t1Iterator.hasNext();) {
//			Entry<Integer, String> e = t1Iterator.next();
//			System.out.println(e);
//		}
		//使用keySet方法，再遍历
		Set<Integer> t1Set = m1Map.keySet();
		for (Iterator<Integer> t1Iterator = t1Set.iterator();t1Iterator.hasNext();) {
			Integer keyInteger = t1Iterator.next();
			System.out.println(keyInteger+" "+m1Map.get(keyInteger));
		}
	}
	//map转list
	public static void mapToList() {
		TestZuoye31 obj = new TestZuoye31(1001, 27, "anxiaolong", Sex.values()[0]);
		TestZuoye31 obj2 = new TestZuoye31(1003, 17, "ereref", Sex.values()[1]);
		TestZuoye31 obj3 = new TestZuoye31(1009, 34, "ttvv", Sex.values()[1]);
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		m1Map.put(obj.id, obj.toString());
		m1Map.put(obj2.id, obj2.toString());
		m1Map.put(obj3.id, obj3.toString());
//		System.out.println(m1Map);
		Set<Entry<Integer, String>> t1Set = m1Map.entrySet();
//		System.out.println(t1Set);
		List<String> t1List = new ArrayList<String>();
		for (Iterator<Entry<Integer, String>> t1Iterator = t1Set.iterator();t1Iterator.hasNext();) {
			Entry<Integer, String> e = t1Iterator.next();
			System.out.println(e);
			t1List.add(e.getValue());
		}
		System.out.println(t1List);
	}
	//list中排序,list中对象实现Comparable接口
	public static void compareable() {
		List<TestZuoye31> t1List = new ArrayList<TestZuoye31>();
		t1List.add(new TestZuoye31(1010, 27, "anxiaolong", Sex.values()[0]));
		t1List.add(new TestZuoye31(1003, 17, "ereref", Sex.values()[1]));
		t1List.add(new TestZuoye31(1009, 34, "ttvv", Sex.values()[1]));
		System.out.println(t1List);
		Collections.sort(t1List);//通过Collections工具类的方法进行排序
		System.out.println(t1List);
	}
	public static void main(String[] args) {
		mapToList();
		listToMap();
		compareable();
	}
}

class TestZuoye31 implements Comparable<TestZuoye31> {
	
	int id;
	int age;
	String name;
	Sex sex;
	
	public TestZuoye31(int id,int age,String name,Sex sex) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return id+" "+age+" "+name+" "+sex;
	}
	
	@Override
	public int compareTo(TestZuoye31 o) {
		if (this.id>o.id) {
			return 1;
		}
		if (this.id<o.id) {
			return -1;
		}
		return 0;
	}
}

enum Sex{
	男,女;
}
