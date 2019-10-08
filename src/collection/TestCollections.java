package collection;
/**
 * 测试Collections类的常用方法
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
	public static void main(String[] args) {
		List<String> t1List = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			t1List.add("a"+i);
		}
		System.out.println(t1List);
		Collections.shuffle(t1List);//随机排序
		System.out.println(t1List);
		Collections.reverse(t1List);
		System.out.println(t1List);//元素逆序，根据当前顺序排
		Collections.sort(t1List);
		System.out.println(t1List);//元素排序，根据string类下的compareTo方法排序
		System.out.println(Collections.binarySearch(t1List, "a4"));//折半查找
		Collections.fill(t1List, "anxiaolong");//用一个元素替换list中所有元素
		System.out.println(t1List);
	}
}
