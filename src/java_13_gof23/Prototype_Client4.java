package java_13_gof23;
/**
 * ����new����Ч�ʺ� clone����Ч��
 * ԭ��ģʽһ�����ڴ�������Ƚ��鷳���߱ȽϺķ�ʱ�������
 * @author Administrator
 *
 */
public class Prototype_Client4 {
	//����new100�������ʱ
	public static void testNew() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Prototype_Sheep3 s1 = new Prototype_Sheep3();
		}
		long end = System.currentTimeMillis();
		System.out.println("new1000�������ʱ��"+(end-start));
	}
	
	//����clone1000�������ʱ
	public static void testClone() throws Exception {
		long start = System.currentTimeMillis();
		Prototype_Sheep3 s = new Prototype_Sheep3();
		for (int i = 0; i < 1000; i++) {
			s.clone();
		}
		long end = System.currentTimeMillis();
		System.out.println("clone1000�������ʱ��"+(end-start));
	}
	
	public static void main(String[] args) throws Exception {
		testClone();
		testNew();
	}
}

class Prototype_Sheep3 implements Cloneable {
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public Prototype_Sheep3() {
		try {
			//ģ��new������Ҫ���ѵ�ʱ��
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}