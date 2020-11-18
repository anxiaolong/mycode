package java_06_collection;
/**
 * List和Map存储表格数据和遍历表格数据
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestZuoye {
	
	//根据key值遍历list中的map
	public static void fromKeyToInput(List<Map<Integer,String>> tt) {
		for (int i = 0; i < tt.size(); i++) {
			//本质上是要把key值转化为set，遍历set再输出对应的value值
			Set<java.util.Map.Entry<Integer, String>> t1Set = tt.get(i).entrySet();
			for (Iterator<java.util.Map.Entry<Integer, String>> tIterator = t1Set.iterator();tIterator.hasNext();) {
				java.util.Map.Entry<Integer, String> e = tIterator.next();
				System.out.println(e.getKey()+" "+e.getValue());
			}
		}
	}
	
	//使用EntrySet遍历list中的map
	public static void fromEntrySet(List<Map<Integer,String>> tt) {
		for (int i = 0; i < tt.size(); i++) {
			Set<Integer> tIntegers = (tt.get(i)).keySet();
			for (Iterator<Integer> test = tIntegers.iterator();test.hasNext();) {
				Integer test1 = test.next();
				System.out.print(test1);
				System.out.println((tt.get(i)).get(test1));
			}		
		}
	}
	
	public static void main(String[] args) {
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		Map<Integer, String> m3 = new HashMap<Integer, String>();
		List<Map<Integer, String>> tt = new ArrayList<Map<Integer,String>>();
		TestZuoye1 book1 = new TestZuoye1(1001, "语文", 48.5, "tt出版");
		TestZuoye1 book2 = new TestZuoye1(1002, "数学", 34, "ss出版");
		TestZuoye1 book3 = new TestZuoye1(1003, "英语", 56.1, "ww出版");
//		System.out.println(book1.toString());
		m1.put(book1.id, book1.toString());
		m2.put(book2.id, book2.toString());
		m3.put(book3.id, book3.toString());
		tt.add(m1);
		tt.add(m2);
		tt.add(m3);
		fromKeyToInput(tt);
		fromEntrySet(tt);
	}
}

class TestZuoye1 {
	int id;
	String name;
	double price;
	String press;
	public TestZuoye1() {}
	public TestZuoye1(int id,String name,double price,String press) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.press = press;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+price+" "+press ;
	}
}