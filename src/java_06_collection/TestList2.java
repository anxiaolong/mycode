package java_06_collection;
/**
 * Vector Linkedlist Arraylist区别
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class TestList2 {
	public static void main(String[] args) {
		//Vector是线程安全，方法中有线程同步
		Vector<String> aVector = new Vector<String>();
		aVector.add("anxiaolong");
		System.out.println(aVector);
		//LinkedList增删效率高，查下效率低，线程不安全
		LinkedList<String> aLinkedList = new LinkedList<String>();
		aLinkedList.add("test");
		System.out.println(aLinkedList);
		//arraylist查询效率高，增删效率低，线程不安全
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("dddd");
		System.out.println(arrayList);
	}
}
