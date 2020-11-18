package java_01_grammar;
/**
 * 变量的本质是一块可操作的存储空间
 * 变量必须声明并且初始化之后才能使用
 * 局部变量、成员变量、静态变量
 * @author 安小龙
 *
 */
public class TestVariable {
	int m; //这是定义的成员变量，和对象共生
	static int w; //这是定义的静态变量，只要对应的类被加载，这个变量就在
	public static void main(String[] args) {
		int a; //这是局部变量，只作用于自己所在{}代码块
//		cc = 24.234;
		int b =1;
		//System.out.println(a); 提示a未被初始化
		System.out.println(b); //正常使用
		//System.out.println(cc); 初始化但是未声明变量也不能使用
			
	}
}
