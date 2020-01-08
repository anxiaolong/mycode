package datastructure;
/**
 * HashSet��LinkedHashSet��TreeSet
 * ���Ƕ�Ӧ��mapʵ�ֵģ�valueֵĬ��Ϊһ��Object����
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Collection_Set {
	public static void main(String[] args) {
		//HashSet��ͨ��HashMapʵ�֣����򲻿��ظ�
		Set<String> set1 = new HashSet<String>();
		set1.add("1");
		set1.add("2");
		set1.add("3");
		
		//LinkedHashSet��ͨ��LinkedHashMapʵ�֣�Ĭ��Ϊ��ӵ�˳��
		Set<String> set2 = new LinkedHashSet<String>();
		set2.add("3");
		set2.add("1");
		set2.add("2");
		
		//TreeSet��ͨ��TreeMapʵ�֣�Ĭ�ϴ�С��������
		Set<String> set3 = new TreeSet<String>();
		set3.add("3");
		set3.add("1");
		set3.add("2");
		
		for (Iterator<String> iterator=set1.iterator();iterator.hasNext();) {
			String temp = iterator.next();
			System.out.println(temp);
		}
		for (Iterator<String> iterator=set2.iterator();iterator.hasNext();) {
			String temp = iterator.next();
			System.out.println(temp);
		}
		for (Iterator<String> iterator=set3.iterator();iterator.hasNext();) {
			String temp = iterator.next();
			System.out.println(temp);
		}
	}
}
