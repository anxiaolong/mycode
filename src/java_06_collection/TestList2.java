package java_06_collection;
/**
 * Vector Linkedlist Arraylist����
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class TestList2 {
	public static void main(String[] args) {
		//Vector���̰߳�ȫ�����������߳�ͬ��
		Vector<String> aVector = new Vector<String>();
		aVector.add("anxiaolong");
		System.out.println(aVector);
		//LinkedList��ɾЧ�ʸߣ�����Ч�ʵͣ��̲߳���ȫ
		LinkedList<String> aLinkedList = new LinkedList<String>();
		aLinkedList.add("test");
		System.out.println(aLinkedList);
		//arraylist��ѯЧ�ʸߣ���ɾЧ�ʵͣ��̲߳���ȫ
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("dddd");
		System.out.println(arrayList);
	}
}
