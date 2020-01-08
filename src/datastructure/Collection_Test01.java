package datastructure;
/**
 * HashMap�洢������������ģ�ʹ��ɢ�б�͵�����ʵ��
 * LinkedHashMap��HashMap�����࣬���������������ģ���put��˳���ڲ�ʵ��ʹ����˫������
 * TreeMap���Զ�����keyֵ��С���������ڲ�ʹ�ú�ڶ�����ʵ��
 * 
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Collection_Test01 {
	public static void main(String[] args) {
		//TreeMap���Զ�����keyֵ��С��������
		//�ڲ�ʹ�ú�ڶ�����ʵ��
		Map<String, String> map1 = new TreeMap<String, String>();
		map1.put("3", "34rerf");
		map1.put("2", "56fef");
		map1.put("1", "11vvd");
		
		//LinkedHashMap��HashMap�����࣬���������������ģ���put��˳��
		//�ڲ�ʵ��ʹ����˫������
		Map<String, String> map2 = new LinkedHashMap<String, String>();
		map2.put("1", "tttttt");
		map2.put("2", "tttttt");
		map2.put("3", "tttttt");
		
		//HashMap�洢������������ģ�ʹ��ɢ�б�͵�����ʵ��
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("1", "233ffd");
		map3.put("2", "455dedd");
		map3.put("3", "errd34");
		
		Set<Entry<String, String>> set1 = map1.entrySet();
		Set<Entry<String, String>> set2 = map2.entrySet();
		Set<Entry<String, String>> set3 = map3.entrySet();
		for (Iterator<Entry<String, String>> iterator=set1.iterator();iterator.hasNext();) {
			Entry<String, String> temp = iterator.next();
			System.out.println(temp);
		}
		for (Iterator<Entry<String, String>> iterator=set2.iterator();iterator.hasNext();) {
			Entry<String, String> temp = iterator.next();
			System.out.println(temp);
		}
		for (Iterator<Entry<String, String>> iterator=set3.iterator();iterator.hasNext();) {
			Entry<String, String> temp = iterator.next();
			System.out.println(temp);
		}
	}
}
