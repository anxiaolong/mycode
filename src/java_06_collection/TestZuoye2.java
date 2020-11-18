package java_06_collection;
/**
 * 测试HashSet存储对象数据，需要重写hashCode和equals方法
 * 测试TreeSet存储对象数据，不仅要重写hashCode和equals，还要实现comparable接口
 * 简历数据模板对象时候，重写下toString方法，要不然存进去就是对象地址
 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestZuoye2 {
	
	//测试HashSet存储对象数据，需要重写hashCode和equals方法
	public static void testHashSet() {
		Set<Books> set1Books = new HashSet<Books>();
		set1Books.add(new Books(12, "rrdf", 23, "tt"));
		set1Books.add(new Books(12, "rrdf", 23, "tt"));
		set1Books.add(new Books(13, "rrdf", 23, "tt"));
		set1Books.add(new Books(17, "rrdf", 23, "tt"));
		System.out.println(set1Books);//这里两个相同的对象add进去，是因为校验的hashCode和equle
	}
	
	//测试TreeSet存储对象数据，不仅要重写hashCode和equals，还要实现comparable接口
	public static void testTreeSet() {
		Set<Books> set2Books = new TreeSet<Books>();
		set2Books.add(new Books(12, "rrdf", 23, "tt"));
		set2Books.add(new Books(12, "rrdf", 23, "tt"));
		set2Books.add(new Books(13, "rrdf", 23, "tt"));
		set2Books.add(new Books(17, "rrdf", 23, "tt"));
		set2Books.add(new Books(22, "rrdf", 23, "tt"));
		System.out.println(set2Books);
	}
	public static void main(String[] args) {
		testHashSet();
		testTreeSet();
		
//		Set<String> teStrings = new HashSet<String>();
//		teStrings.add("a");
//		teStrings.add("a");
//		System.out.println(teStrings);//测试结果是HashSet是无法添加两个元素进去的
	}
}


class Books implements Comparable<Books> {
	
	int id;
	String name;
	double price;
	String press;
	
	public Books(int id,String name,double price,String press) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.press = press;
	}
	
	@Override
	public String toString() {
		return id+" "+name+" "+price+" "+press;
	}
	
	@Override
	public int hashCode() {
		int result = 17;//可以定义为任一值
		Integer idInteger = (Integer) this.id;//转为为Integer，方便调用对应的hashCode()
		result = 31*result + idInteger.hashCode();//任何数n*31都可以被jvm优化为(n<<5)-n，移位和减法的操作效率比乘法的操作效率高很多
		System.out.println(result);
		return result;//默认的hashCode是通过对象地址算算出来的，所以上面两个对象判断为不同
	}
	
	@Override
	public boolean equals(Object obj) {
		Books books = (Books) obj;//转为books对象，方便比较id
		if (this.id==books.id) {
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Books o) {
		if (this.id>o.id) {
			return 1;
		}
		if (this.id<o.id) {
			return -1;
		}
		return 0;
	}

}