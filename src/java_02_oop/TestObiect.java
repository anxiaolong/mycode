package java_02_oop;

import javax.rmi.CORBA.Tie;

public class TestObiect extends Object {
	public static void main(String[] args) {
		TestObiect t1 = new TestObiect();
		System.out.println(t1); //默认执行tostring方法
		TestObject1 t2 = new TestObject1(27,"anxiaolong"); //调用重写的tostring
		System.out.println(t2); 
		TestObiect t3 = new TestObiect();
		System.out.println(t1.equals(t3)); //object 默认equals方返回this==obj,t1不等于t3
		t3 = t1; //将t1 赋值给t3
		System.out.println(t1.equals(t3)); //两个相同
		TestObject1 t4 = new TestObject1(25,"anxiaolong");  
		System.out.println(t2.equals(t4)); //t2和t4 年龄不同，姓名相同，调用重写的equl方法
	}
}

class TestObject1 {
	int age;
	String name;
	
	public TestObject1(int age,String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override //重写object类的tostring方法
	public String toString() {
		return (this.name+" "+this.age);
	}
	
	@Override //重写equls
	public boolean equals(Object obj) {
		if (obj instanceof TestObject1 == true && this.name ==((TestObject1) obj).name) {
			return true;
		} else {
			return false;
		}
		
	}
}