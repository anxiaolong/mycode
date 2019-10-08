package collection;
/**
 * ����Collections��ĳ��÷���
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
		Collections.shuffle(t1List);//�������
		System.out.println(t1List);
		Collections.reverse(t1List);
		System.out.println(t1List);//Ԫ�����򣬸��ݵ�ǰ˳����
		Collections.sort(t1List);
		System.out.println(t1List);//Ԫ�����򣬸���string���µ�compareTo��������
		System.out.println(Collections.binarySearch(t1List, "a4"));//�۰����
		Collections.fill(t1List, "anxiaolong");//��һ��Ԫ���滻list������Ԫ��
		System.out.println(t1List);
	}
}
