package java_06_collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * ����Map�ӿں���ʵ����HashMap
 * @author Administrator
 *
 */
public class TestMap {
	public static void main(String[] args) {
		//HashMap: �̲߳���ȫ��Ч�ʸߡ�����key��valueΪnull
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Map<Integer, String> m2 = new HashMap<Integer, String>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		m2.put(1, "һ");
		m2.put(2, "��");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m1.size());//m1�ĳ���
		System.out.println(m1.containsKey(2));//m1�Ƿ������ֵ2
		System.out.println(m2.containsValue("��"));//m2�Ƿ���������valueֵ
		m1.put(3, "anxiaolong");//�Ѵ��ڵļ�ֵ�ԣ�����֮ǰ
		Map<Integer, String> m3 = new HashMap<Integer, String>();
		m3.putAll(m1);
		m3.putAll(m2);//��ֵ�Լ��뵽m3�У���ͬkeyֵ��Ӧ��ֵ����Ϊm2��
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		//HashTable: �̰߳�ȫ��Ч�ʵ͡�������key��valueΪnull
		Map<Integer, String> m4 = new Hashtable<Integer, String>();
	}
}
