package oop;

//未extends的类 默认都继承object类
public class TestExtends {
	public static void main(String[] args) {
		Student916 stu1 = new Student916("anxiaolong", 27, "201110412121");
		stu1.zouLu(); //继承了父类的方法可以直接使用
		stu1.paoBu(); //重写overrides 了父类的方法
		People p1 = new People();
		System.out.println(stu1 instanceof People); //instanceof 测试左边对象是否是右边类或子类创建
		System.out.println(stu1 instanceof Student916);
		System.out.println(p1 instanceof Student916); //父类的对象不属于子类
	}
}

class People {
	String name;
	int age;
	
	public void zouLu() {
		System.out.println("走路");
	}
	public void paoBu() {
		System.out.println("跑步");
	}
}

class Student916 extends People {
	String stuid;
	
	public void xueXi() {
		System.out.println("学习");
		this.zouLu();
	}
	
	public void paoBu() {
		System.out.println("重写父类的跑步");
	}
	
	public Student916(String name,int age,String stuid) {
		//因为继承了父类 People，拥有其所有成员变量
		this.name = name;
		this.age = age;
		this.stuid = stuid;
	}
	
}