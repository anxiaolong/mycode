package java_06_collection;
/**
 * 测试List接口常用方法，实现类arraylist
 */
import java.util.ArrayList;
import java.util.List;

public class TestList {
	//list常用方法
	public static void test1() {
		List<String> l1List = new ArrayList<String>();
		System.out.println(l1List.isEmpty()); //刚建立好为空
		l1List.add("anxiaolong");
		System.out.println(l1List.isEmpty()); 
		l1List.add("ddegag");
		l1List.add("testdff-dfe");
		System.out.println(l1List);
		System.out.println(l1List.size()); //查看list大小 
		System.out.println(l1List.contains("anxiaolong")); //是否包含元素
		l1List.remove("ddegag"); //移除某个元素
		System.out.println(l1List);
		l1List.toArray();//转化为数组
		System.out.println(l1List);
		l1List.clear();//清空list
		System.out.println(l1List);
	}
	//两个list的元素处理
	public static void test2() {
		List<Integer> l1Integers = new ArrayList<Integer>();
		l1Integers.add(23);
		l1Integers.add(12);
		l1Integers.add(45);
		List<Integer> l2Integers = new ArrayList<Integer>();
		l2Integers.add(12);
		l2Integers.add(66);
		l2Integers.add(77);
		System.out.println(l1Integers.containsAll(l2Integers));//l1是否包含所有l2中元素
		l1Integers.addAll(l2Integers);//l2中所有元素添加到l1
		System.out.println(l1Integers);
		l1Integers.removeAll(l2Integers);//l1中删除和l2相同元素
		System.out.println(l1Integers); 
		l1Integers.retainAll(l2Integers);//l1中保留和l2相同的元素，求交集
		System.out.println(l1Integers);
	}
	//list下标常用操作
	public static void test3() {
		List<String> s1List = new ArrayList<String>();
		s1List.add("a");
		s1List.add("b");
		s1List.add("c");
		s1List.add("d");
		System.out.println(s1List);
		s1List.add(3, "anxiaolong");//指定下标位置插入元素，后面的自动后移
		System.out.println(s1List);
		System.out.println(s1List.get(3));//获取指定下标位置元素
		s1List.add("b");
		System.out.println(s1List);
		System.out.println(s1List.lastIndexOf("b"));//从后向前第一个
		System.out.println(s1List.indexOf("b"));//从前到后第一个
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
