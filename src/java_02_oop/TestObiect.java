package java_02_oop;

import javax.rmi.CORBA.Tie;

public class TestObiect extends Object {
	public static void main(String[] args) {
		TestObiect t1 = new TestObiect();
		System.out.println(t1); //Ĭ��ִ��tostring����
		TestObject1 t2 = new TestObject1(27,"anxiaolong"); //������д��tostring
		System.out.println(t2); 
		TestObiect t3 = new TestObiect();
		System.out.println(t1.equals(t3)); //object Ĭ��equals������this==obj,t1������t3
		t3 = t1; //��t1 ��ֵ��t3
		System.out.println(t1.equals(t3)); //������ͬ
		TestObject1 t4 = new TestObject1(25,"anxiaolong");  
		System.out.println(t2.equals(t4)); //t2��t4 ���䲻ͬ��������ͬ��������д��equl����
	}
}

class TestObject1 {
	int age;
	String name;
	
	public TestObject1(int age,String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override //��дobject���tostring����
	public String toString() {
		return (this.name+" "+this.age);
	}
	
	@Override //��дequls
	public boolean equals(Object obj) {
		if (obj instanceof TestObject1 == true && this.name ==((TestObject1) obj).name) {
			return true;
		} else {
			return false;
		}
		
	}
}