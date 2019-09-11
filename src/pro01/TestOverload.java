package pro01;

public class TestOverload {
	public static void main(String[] args) {
		System.out.println(Jia(1, 3.12));
		System.out.println(Jia(1, 1, 1));
		System.out.println(Jia(3.99, 8));
		
		Jia("anxiaolong");
		
	}
	
	public static  double Jia(int a,double b) {
		return a+b;
	}
	//方法名相同，参数个数不同，构成重载
	public static int Jia(int a,int b,int c) {
		return a+b+c;
	}
	//方法名相同，参数不同，构成重载
	public static void Jia(String s) {
		System.out.println(s);
	}
	//方法名相同，参数顺序不同，构成重载
	public static  double Jia(double a,int b) {
		return a+b;
	}
	//只有返回值不同，不构成重载
	//只有参数名称不同，不构成重载
}

