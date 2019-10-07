package collection;
/**
 * test TreeSet 
 * 内部需要排序，不能有null
 */
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		People p1People = new People(23, "test");
		People p2People = new People(18, "anxiaolong");
		Set<People> s1Peoples = new TreeSet<People>();
		s1Peoples.add(p1People);
		s1Peoples.add(p2People);
		System.out.println(s1Peoples);
//		s1Peoples.add(null);//TreeSet不允许有空值
	}
}

//因为TreeSet内部需要排序，所以存入对象需要实现Comparable接口
class People implements Comparable<People> {
	private int age;
	private String name;
	
	public People(int age,String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(People o) {
		if (this.age>o.age) {
			return 1;
		} else if (this.age<o.age) {
			return -1;
		} else {
			return 0;
		}
	}
}