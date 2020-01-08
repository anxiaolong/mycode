package datastructure;
/**
 * HashSet，LinkedHashSet，TreeSet
 * 都是对应的map实现的，value值默认为一个Object对象
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Collection_Set {
	public static void main(String[] args) {
		//HashSet是通过HashMap实现，无序不可重复
		Set<String> set1 = new HashSet<String>();
		set1.add("1");
		set1.add("2");
		set1.add("3");
		
		//LinkedHashSet是通过LinkedHashMap实现，默认为添加的顺序
		Set<String> set2 = new LinkedHashSet<String>();
		set2.add("3");
		set2.add("1");
		set2.add("2");
		
		//TreeSet是通过TreeMap实现，默认从小到大排序
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
