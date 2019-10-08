package collection;
/**
 * iterator����������list��set
 * ����map����ʹ��entrySet()��keySet()�Ƚ���Ӧ��ֵ�洢��set���ٱ���
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
	//iterator����������list
	public static void test1() {
		List<String> t1 = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			t1.add("a"+i);
		}
		System.out.println(t1);
		//����һ������������ѭ��������hasNext()Ϊ��
		for (Iterator<String> testIterator = t1.iterator();testIterator.hasNext();) {
			String tempString = testIterator.next();//����һ�Σ�����ƽ�һλ
			System.out.println(tempString);
			if (tempString.endsWith("3")) {
				testIterator.remove();//ʹ�õ������ķ���ɾ����3��β��Ԫ��
			}
		System.out.println(t1);
		}
	}
	//iterator����set
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
	//iterator����map��ʹ��entrySet()����ֵ�Դ浽set���ٱ���
	public static void test3() {
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		TestIterator1 t1Iterator1 = new TestIterator1(23, "anxiaolong");
		TestIterator1 t2Iterator1 = new TestIterator1(18, "test");
		TestIterator1 t3Iterator1 = new TestIterator1(19, "rrgrggr");
		m1Map.put(t1Iterator1.age,t1Iterator1.name);
		m1Map.put(t2Iterator1.age,t2Iterator1.name);
		m1Map.put(t3Iterator1.age,t3Iterator1.name);
		System.out.println(m1Map);
		Set<Entry<Integer, String>> ss = m1Map.entrySet();//����ֵ�Ա��浽һ��set��
		for (Iterator<Entry<Integer, String>> tt = ss.iterator();tt.hasNext();) {
			Entry<Integer, String> temEntry = tt.next();
			System.out.println(temEntry.getKey()+" "+temEntry.getValue());
		}
	}
	//iterator����map��ʹ��keySet()�Ƚ���ֵ�洢����ͨ����ֵ��valueֵ
	public static void test4() {
		Map<Integer, String> m1Map = new HashMap<Integer, String>();
		TestIterator1 t1Iterator1 = new TestIterator1(23, "anxiaolong");
		TestIterator1 t2Iterator1 = new TestIterator1(18, "test");
		TestIterator1 t3Iterator1 = new TestIterator1(19, "rrgrggr");
		m1Map.put(t1Iterator1.age,t1Iterator1.name);
		m1Map.put(t2Iterator1.age,t2Iterator1.name);
		m1Map.put(t3Iterator1.age,t3Iterator1.name);
		System.out.println(m1Map);
		
		Set<Integer> ttIntegers = m1Map.keySet();//�Ѽ�ֱ���浽set����
		for (Iterator<Integer> testIterator = ttIntegers.iterator();testIterator.hasNext();) {
			Integer keyInteger = testIterator.next();
			System.out.println(keyInteger+" "+m1Map.get(keyInteger));//ͨ��keyֵ��������valueֵ
		}
	}
	//ʹ��ѭ������
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

//дһ�����������ڲ���map
class TestIterator1 {
	int age;
	String name;
	
	public TestIterator1(int age,String name) {
		this.age = age;
		this.name = name;
	}
}

