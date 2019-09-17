package oop;
/**
 * 测试多态和对象类型的强制转换
 * @author Administrator
 *
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		Animal a1Animal = new Dog(); //父类的引用，指向子类
		Animal a2Animal = new Cat(); 
		a1Animal.Jiao(); 
		a2Animal.Jiao();
//		a1Animal.kanMen(); //无法调用子类的其他方法，只能调用重写的方法
		Dog dog1Dog = (Dog)(a1Animal);
		System.out.println(a1Animal instanceof Dog);
		System.out.println(a1Animal instanceof Cat); //向下转型，使用instanceof进行判断是否是目标类或子类对象
//		Cat cat1Cat = (Cat)(a1Animal); //a1Animal对象是指向dog，强转未cat会异常
		dog1Dog.kanMen(); //转未dog之后，即可调用dog的非重写的方法
	}
}

class Animal {
	
	public void Jiao() {
		System.out.println("叫");
	}
}

class Dog extends Animal {
	
	@Override
	public void Jiao() {		
		System.out.println("汪汪汪");;
	}
	
	public void kanMen() {
		System.out.println("看门");
	}
}

class Cat extends Animal {
	@Override
	public void Jiao() {
		System.out.println("喵喵喵");
	}
}