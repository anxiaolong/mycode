package java_02_oop;
//import static java.lang.Math.PI; //导入静态变量PI
import static java.lang.Math.*; //导入math中多有的静态变量

import java_01_grammar.TestDg;


public class TestImport {
	public static void main(String[] args) {
		
//		pro01.TestDg d = new pro01.TestDg(); //调用不同包中的类，如果import包中的类有重名，只能这样写
		TestDg d = new TestDg();
		System.out.println(PI);
		
	}
}
