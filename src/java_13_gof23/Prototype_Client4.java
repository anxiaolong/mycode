package java_13_gof23;
/**
 * 测试new对象效率和 clone对象效率
 * 原型模式一般用在创建对象比较麻烦或者比较耗费时间情况下
 * @author Administrator
 *
 */
public class Prototype_Client4 {
	//测试new100个对象耗时
	public static void testNew() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Prototype_Sheep3 s1 = new Prototype_Sheep3();
		}
		long end = System.currentTimeMillis();
		System.out.println("new1000个对象耗时："+(end-start));
	}
	
	//测试clone1000个对象耗时
	public static void testClone() throws Exception {
		long start = System.currentTimeMillis();
		Prototype_Sheep3 s = new Prototype_Sheep3();
		for (int i = 0; i < 1000; i++) {
			s.clone();
		}
		long end = System.currentTimeMillis();
		System.out.println("clone1000个对象耗时："+(end-start));
	}
	
	public static void main(String[] args) throws Exception {
		testClone();
		testNew();
	}
}

class Prototype_Sheep3 implements Cloneable {
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public Prototype_Sheep3() {
		try {
			//模拟new对象需要花费的时间
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}