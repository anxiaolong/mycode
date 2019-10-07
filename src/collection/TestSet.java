package collection;
/**
 * HashSet的特点是无序，不可重复，只能有一个null
 */
import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		s1.add("test");
		s1.add("anxiaolong");
		System.out.println(s1);
		s1.add("anxiaolong");//元素相同不会被加入
		System.out.println(s1);
		s1.add(null);
		System.out.println(s1);
		s1.add(null);//set中只允许有一个null
		System.out.println(s1);
	}
}
