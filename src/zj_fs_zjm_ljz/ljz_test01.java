package zj_fs_zjm_ljz;
/**
 * 测试类的加载
 * @author Administrator
 *
 */
public class ljz_test01 {
	static {
		System.out.println("lzj_test01的static块");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("lzj_test01的main方法");
//		System.out.println(System.getProperty("java.class.path"));
		
		//主动引用
//		new A();
//		System.out.println(A.width);
//		Class.forName("zj_fs_zjm_ljz.A");
		
		//被动引用
//		System.out.println(A.MAX);
//		A[] as = new A[10];
		System.out.println(B.width);
	}
}


class A_Father extends Object {
	static {
		System.out.println("A_Father的static块");
	}
}

class A extends A_Father {
	public static int width = 100;
	public static final int MAX = 100;
	
	static {
		System.out.println("静态初始化A");
		width = 300;
	}
	
	public A() {
		System.out.println("创建A对象");
	}
	
}

class B extends A {
	static {
		System.out.println("静态初始化B");
	}
}





