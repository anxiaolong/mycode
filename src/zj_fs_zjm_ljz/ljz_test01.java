package zj_fs_zjm_ljz;
/**
 * ������ļ���
 * @author Administrator
 *
 */
public class ljz_test01 {
	static {
		System.out.println("lzj_test01��static��");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("lzj_test01��main����");
//		System.out.println(System.getProperty("java.class.path"));
		
		//��������
//		new A();
//		System.out.println(A.width);
//		Class.forName("zj_fs_zjm_ljz.A");
		
		//��������
//		System.out.println(A.MAX);
//		A[] as = new A[10];
		System.out.println(B.width);
	}
}


class A_Father extends Object {
	static {
		System.out.println("A_Father��static��");
	}
}

class A extends A_Father {
	public static int width = 100;
	public static final int MAX = 100;
	
	static {
		System.out.println("��̬��ʼ��A");
		width = 300;
	}
	
	public A() {
		System.out.println("����A����");
	}
	
}

class B extends A {
	static {
		System.out.println("��̬��ʼ��B");
	}
}





