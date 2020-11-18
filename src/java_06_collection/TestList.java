package java_06_collection;
/**
 * ����List�ӿڳ��÷�����ʵ����arraylist
 */
import java.util.ArrayList;
import java.util.List;

public class TestList {
	//list���÷���
	public static void test1() {
		List<String> l1List = new ArrayList<String>();
		System.out.println(l1List.isEmpty()); //�ս�����Ϊ��
		l1List.add("anxiaolong");
		System.out.println(l1List.isEmpty()); 
		l1List.add("ddegag");
		l1List.add("testdff-dfe");
		System.out.println(l1List);
		System.out.println(l1List.size()); //�鿴list��С 
		System.out.println(l1List.contains("anxiaolong")); //�Ƿ����Ԫ��
		l1List.remove("ddegag"); //�Ƴ�ĳ��Ԫ��
		System.out.println(l1List);
		l1List.toArray();//ת��Ϊ����
		System.out.println(l1List);
		l1List.clear();//���list
		System.out.println(l1List);
	}
	//����list��Ԫ�ش���
	public static void test2() {
		List<Integer> l1Integers = new ArrayList<Integer>();
		l1Integers.add(23);
		l1Integers.add(12);
		l1Integers.add(45);
		List<Integer> l2Integers = new ArrayList<Integer>();
		l2Integers.add(12);
		l2Integers.add(66);
		l2Integers.add(77);
		System.out.println(l1Integers.containsAll(l2Integers));//l1�Ƿ��������l2��Ԫ��
		l1Integers.addAll(l2Integers);//l2������Ԫ����ӵ�l1
		System.out.println(l1Integers);
		l1Integers.removeAll(l2Integers);//l1��ɾ����l2��ͬԪ��
		System.out.println(l1Integers); 
		l1Integers.retainAll(l2Integers);//l1�б�����l2��ͬ��Ԫ�أ��󽻼�
		System.out.println(l1Integers);
	}
	//list�±곣�ò���
	public static void test3() {
		List<String> s1List = new ArrayList<String>();
		s1List.add("a");
		s1List.add("b");
		s1List.add("c");
		s1List.add("d");
		System.out.println(s1List);
		s1List.add(3, "anxiaolong");//ָ���±�λ�ò���Ԫ�أ�������Զ�����
		System.out.println(s1List);
		System.out.println(s1List.get(3));//��ȡָ���±�λ��Ԫ��
		s1List.add("b");
		System.out.println(s1List);
		System.out.println(s1List.lastIndexOf("b"));//�Ӻ���ǰ��һ��
		System.out.println(s1List.indexOf("b"));//��ǰ�����һ��
	}
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
