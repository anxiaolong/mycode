package oop;
/**
 * 权限关键字      本类      本包       其他包子类     其他包其他类
 * private     1      0         0           0
 * default     1      1         0           0
 * protected   1      1         1           0
 * public      1       1         1          1
 * 权限关键字对方法和成员变量都适用
 * 测试get和set
 * @author Administrator
 *
 */

public class TestFZ {
	public static void main(String[] args) {
		TestFZ1 t1Fz1 = new TestFZ1();
		TestFZ1 t1Fz2 = new TestFZ1();
//		System.out.println(t1Fz1.name); //不可直接访问私有属性
		t1Fz1.setAge(-12); //通过set这是对象属性值
		System.out.println(t1Fz1.getAge()); //通过get获取对象属性值
		System.out.println(t1Fz1.isSex()); //布尔类型的获取使用is不是get
	}
}

class TestFZ1 {
	private String name;
	private int age;
	private boolean sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		//set方法的好处是，在这里可以设置参数的条件
		if (age>130||age<0) {
			System.out.println("年龄必须小于130的正数"); 
		} else {
			this.age = age;
		}
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
}