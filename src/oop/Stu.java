package oop;
/**
 * 面向对象的简单举例
 * @author Administrator
 *
 */
class Computer{
	//定义一个电脑类，设置一个属性品牌
	String brand;
}

public class Stu {
	//field 类的属性，即类的成员变量
	int id;
	String name;
	int age;
	//Stu这个类的成员变量，是另外一个类的对象
	Computer comp;
	
	//Stu这个类的方法
	public void Study() {
		System.out.println("这是学习的方法执行");
	}
	
	//Stu这个类的构造方法，不写会自动创建
	public Stu() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		//调用类的构造方法,新建一个Stu对象stu1
		Stu stu1 = new Stu();
		//给stu1这个对象的name赋值
		stu1.name = "anxiaolong";
		//新建一个Computer对象
		Computer comp1 = new Computer();
		//设置comp1这个对象的属性值
		comp1.brand = "thinkpad";
		//设置stu1这个对象的属性值
		stu1.comp = comp1;
		//对象实质上，是一个内存地址：oop.Computer@15db9742
		System.out.println(comp1);
		//作为对象stu1，具备Stu这个类的全部方法
		stu1.Study();
	}
}
