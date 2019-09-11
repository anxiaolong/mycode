package pro01;

public class TestMethod {
	public static void main(String[] args) {
		//Jia方法没有加static,需要创建一个对象再使用
		TestMethod test = new TestMethod();
		System.out.println(test.Jia(1, 4));
		//直接调用Pt
		Pt();
	}
	
	//定义一个计算整数加法的方法
	public int Jia(int a,int b) {
		//return有两个作用，一个是返回结果，一个是结束方法
		return a+b;
	}
	//void表示该方法没有返回值，如果有返回值，这个位置写返回值的类型
	public static void Pt() {
		System.out.println("执行了Pt方法");
	}
}
