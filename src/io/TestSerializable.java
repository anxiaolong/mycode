package io;
/**
 * 实现了Serializable接口的自定义类才能
 * 使用writeObject()和readObject()方法
 * 把对象包装成流进行传输，写入文件的操作也被叫做持久化
 * transient修饰的变量不能被序列化
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerializable {
	public static void main(String[] args) {
		String file = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			TestSerializable1 t1 = new TestSerializable1(27, "anxiaolong", "test serializable");
			oos.writeObject(t1);
			oos.flush();
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			//readObject()方法返回的是一个对象，需要转为对应的对象才能使用
			TestSerializable1 t2 = (TestSerializable1)ois.readObject();
			System.out.println(t2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ois!=null) {
					ois.close();
				}
				System.out.println("ois关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (oos!=null) {
					oos.close();
				}
				System.out.println("oos关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class TestSerializable1 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int age;
	transient String name;//transient修饰的变量不能被序列化
	String test;
	
	public TestSerializable1(int age,String name,String test) {
		this.age = age;
		this.name = name;
		this.test = test;
	}
	
	@Override
	public String toString() {
		return name+" "+age+" "+test;
	}
}