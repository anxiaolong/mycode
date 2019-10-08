package collection;
/**
 * iterator迭代器遍历list和set
 * 遍历map可以使用entrySet()和keySet()先将对应的值存储到set中再遍历
 */
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestIterator {
	//iterator迭代器遍历list
	public static void test1() {
		List<String> t1 = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			t1.add("a"+i);
		}
		System.out.println(t1);
		//创建一个迭代器对象，循环条件是hasNext()为真
		for (Iterator<String> testIterator = t1.iterator();testIterator.hasNext();) {
			String tempString = testIterator.next();//运行一次，向后推进一位
			System.out.println(tempString);
			if (tempString.endsWith("3")) {
				testIterator.remove();//使用迭代器的方法删除以3结尾的元素
			}
		System.out.println(t1);
		}
	}
	//iterator遍历set
	public static void test2() {
		Set<String> aSet = new HashSet<String>();
		for (int i = 0; i < 6; i++) {
			aSet.add("a"+i);
		}
		System.out.println(aSet);
		for (Iterator<String> aIterator = aSet.iterator();aIterator.hasNext();) {
			String temp = aIterator.next();
			System.out.println(temp);
		}
	}
	//iterator遍历map，使用entrySet()将键值对存到set中再遍历
	public static void test3() {
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		TestIterator1 t1Iterator1 = new TestIterator1(23, "anxiaolong");
		TestIterator1 t2Iterator1 = new TestIterator1(18, "test");
		TestIterator1 t3Iterator1 = new TestIterator1(19, "rrgrggr");
		m1Map.put(t1Iterator1.age,t1Iterator1.name);
		m1Map.put(t2Iterator1.age,t2Iterator1.name);
		m1Map.put(t3Iterator1.age,t3Iterator1.name);
		System.out.println(m1Map);
		Set<Entry<Integer, String>> ss = m1Map.entrySet();//将键值对保存到一个set中
		for (Iterator<Entry<Integer, String>> tt = ss.iterator();tt.hasNext();) {
			Entry<Integer, String> temEntry = tt.next();
			System.out.println(temEntry.getKey()+" "+temEntry.getValue());
		}
	}
	//iterator遍历map，使用keySet()先将键值存储，再通过键值找value值
	public static void test4() {
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		TestIterator1 t1Iterator1 = new TestIterator1(23, "anxiaolong");
		TestIterator1 t2Iterator1 = new TestIterator1(18, "test");
		TestIterator1 t3Iterator1 = new TestIterator1(19, "rrgrggr");
		m1Map.put(t1Iterator1.age,t1Iterator1.name);
		m1Map.put(t2Iterator1.age,t2Iterator1.name);
		m1Map.put(t3Iterator1.age,t3Iterator1.name);
		System.out.println(m1Map);
		
		Set<Integer> ttIntegers = m1Map.keySet();//把简直保存到set里面
		for (Iterator<Integer> testIterator = ttIntegers.iterator();testIterator.hasNext();) {
			Integer keyInteger = testIterator.next();
			System.out.println(keyInteger+" "+m1Map.get(keyInteger));//通过key值，反向找value值
		}
	}
	//使用循环遍历
	public static void test5() {
		List<String> ttList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			ttList.add("a"+i);
		}
		System.out.println(ttList);
		for (int i = 0; i < ttList.size(); i++) {
			System.out.println(ttList.get(i));
		}
	}
	public static void main(String[] args) {
		test5();
	}
}

//写一个测试类用于测试map
class TestIterator1 {
	int age;
	String name;
	
	public TestIterator1(int age,String name) {
		this.age = age;
		this.name = name;
	}
}

