package io;
/**
 * ʵ����Serializable�ӿڵ��Զ��������
 * ʹ��writeObject()��readObject()����
 * �Ѷ����װ�������д��䣬д���ļ��Ĳ���Ҳ�������־û�
 * transient���εı������ܱ����л�
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
			//readObject()�������ص���һ��������ҪתΪ��Ӧ�Ķ������ʹ��
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
				System.out.println("ois�ر�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (oos!=null) {
					oos.close();
				}
				System.out.println("oos�ر�");
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
	transient String name;//transient���εı������ܱ����л�
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