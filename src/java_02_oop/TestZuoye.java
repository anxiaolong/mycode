package java_02_oop;

import static java.lang.Math.PI;

import org.omg.stub.java.rmi._Remote_Stub;

class Person {
	String _name;
	int _age;
	
	//定义构造方法
	public Person(String a,int b) {
		super();
		_name = a;
		_age = b;
	}
	//定义打印出属性的方法
	public void Display() {
		System.out.println(this._name+" "+this._age);
	}
}

class Circle {
	double _r;
	
	//构造方法
	public Circle(double r) {
		// TODO Auto-generated constructor stub
		_r = r;
	}
	//计算圆的周长
	public void getPerimeter() {
		System.out.println(2*PI*this._r);
	}
	//计算面积
	public void getArea() {
		System.out.println(PI*Math.pow(this._r, 2));
	}
	
}

public class TestZuoye {
	public static void main(String[] args) {
		Person p1 = new Person("anxiaolong", 27);
		p1.Display(); 
		
		Circle c1 = new Circle(5);
		c1.getArea();
		c1.getPerimeter();
	}
}
