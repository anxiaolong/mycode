package java_06_collection;
/**
 * ����HashSet�洢�������ݣ���Ҫ��дhashCode��equals����
 * ����TreeSet�洢�������ݣ�����Ҫ��дhashCode��equals����Ҫʵ��comparable�ӿ�
 * ��������ģ�����ʱ����д��toString������Ҫ��Ȼ���ȥ���Ƕ����ַ
 */

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestZuoye2 {
	
	//����HashSet�洢�������ݣ���Ҫ��дhashCode��equals����
	public static void testHashSet() {
		Set<Books> set1Books = new HashSet<Books>();
		set1Books.add(new Books(12, "rrdf", 23, "tt"));
		set1Books.add(new Books(12, "rrdf", 23, "tt"));
		set1Books.add(new Books(13, "rrdf", 23, "tt"));
		set1Books.add(new Books(17, "rrdf", 23, "tt"));
		System.out.println(set1Books);//����������ͬ�Ķ���add��ȥ������ΪУ���hashCode��equle
	}
	
	//����TreeSet�洢�������ݣ�����Ҫ��дhashCode��equals����Ҫʵ��comparable�ӿ�
	public static void testTreeSet() {
		Set<Books> set2Books = new TreeSet<Books>();
		set2Books.add(new Books(12, "rrdf", 23, "tt"));
		set2Books.add(new Books(12, "rrdf", 23, "tt"));
		set2Books.add(new Books(13, "rrdf", 23, "tt"));
		set2Books.add(new Books(17, "rrdf", 23, "tt"));
		set2Books.add(new Books(22, "rrdf", 23, "tt"));
		System.out.println(set2Books);
	}
	public static void main(String[] args) {
		testHashSet();
		testTreeSet();
		
//		Set<String> teStrings = new HashSet<String>();
//		teStrings.add("a");
//		teStrings.add("a");
//		System.out.println(teStrings);//���Խ����HashSet���޷��������Ԫ�ؽ�ȥ��
	}
}


class Books implements Comparable<Books> {
	
	int id;
	String name;
	double price;
	String press;
	
	public Books(int id,String name,double price,String press) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.press = press;
	}
	
	@Override
	public String toString() {
		return id+" "+name+" "+price+" "+press;
	}
	
	@Override
	public int hashCode() {
		int result = 17;//���Զ���Ϊ��һֵ
		Integer idInteger = (Integer) this.id;//תΪΪInteger��������ö�Ӧ��hashCode()
		result = 31*result + idInteger.hashCode();//�κ���n*31�����Ա�jvm�Ż�Ϊ(n<<5)-n����λ�ͼ����Ĳ���Ч�ʱȳ˷��Ĳ���Ч�ʸߺܶ�
		System.out.println(result);
		return result;//Ĭ�ϵ�hashCode��ͨ�������ַ��������ģ������������������ж�Ϊ��ͬ
	}
	
	@Override
	public boolean equals(Object obj) {
		Books books = (Books) obj;//תΪbooks���󣬷���Ƚ�id
		if (this.id==books.id) {
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Books o) {
		if (this.id>o.id) {
			return 1;
		}
		if (this.id<o.id) {
			return -1;
		}
		return 0;
	}

}