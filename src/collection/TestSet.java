package collection;
/**
 * HashSet���ص������򣬲����ظ���ֻ����һ��null
 */
import java.util.HashSet;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		s1.add("test");
		s1.add("anxiaolong");
		System.out.println(s1);
		s1.add("anxiaolong");//Ԫ����ͬ���ᱻ����
		System.out.println(s1);
		s1.add(null);
		System.out.println(s1);
		s1.add(null);//set��ֻ������һ��null
		System.out.println(s1);
	}
}
