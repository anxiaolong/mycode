package collection;

/**
 * ���Է���generics
 * @author Administrator
 *
 */
public class TestGenerics {
	public static void main(String[] args) {
		//ȷ��������EΪstring
		Mycollection<String> t = new Mycollection();
		t.setA("anxiaolong", 0);
		t.setA("test", 1);
		String s = t.getA(0);//�浽Object[]������Ƕ��󣬷��Ͷ���Ϊstring��ȡ��ʱ��ֱ�Ӿ���string����
		System.out.println(s);
	}
}

class Mycollection<E> { //ʹ�÷��ͱ����������ӱ�ʶ
	Object[] a = new Object[5];  //����һ��Object���͵�һά����

	public E getA(int index) { //����ֵ�Ƿ��ͣ���E��ʾ
		return (E) a[index]; //a[index]��˵�����;ͷ���˵������
	}

	public void setA(E e,int index) {  //E e ��ʾ��һ����
		this.a[index] = e;  //e��ֵ��a[index]
	}
}