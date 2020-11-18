package java_01_grammar;

public class TestDg {
	
	public static void main(String[] args) {
//		System.out.println(Dg(10));
		//使用循环实现
		int s = 1;
		for (int i = 1; i <= 10; i++) {
			s *= i;
		}
		System.out.println(s);
	}
//    public static long Dg(int a) {
//		//a==1是递归头，结束递归
//		if (a == 1) {
//			return 1;	
//		} else {
//			//返回a*Dg(a-1)是递归体
//			return a*Dg(a-1);
//		}
//	}

}
