package datastructure;
/**
 * 测试自己实现的arraylist
 * @author Administrator
 *
 */
public class LineTable_TestMyArrayList {
	public static void main(String[] args) {
		LineTable_ArrayList mylist = new LineTable_ArrayList();
		
		mylist.add("fdfd");
		mylist.add("3434");
		mylist.add("gggg");
		mylist.add("yyyyyy");
		mylist.add("erer");
		mylist.add("erer");
		mylist.add("776757");
		mylist.add("121dsdsd");
		mylist.add("121dsdsd");
		mylist.add(10, "fdf");
		
		System.out.println(mylist.size());
		System.out.println(mylist.isEmpty());
		System.out.println(mylist.get(3));
		System.out.println(mylist.toString());
	}
}
