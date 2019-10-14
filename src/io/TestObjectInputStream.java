package io;
/**
 * 测试对象流读取和写入，写入的对象类需要实现序列化和序列化
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestObjectInputStream {
	public static void main(String[] args) {
		String file = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		try {
			//逐级新建一个ObjectOutputStream对象
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			//ObjectOutputStream对象写入操作，操作文件之前定义了输入流ObjectInputStream对象会报错
			oos.writeObject(new Date());//写入的类需要实现序列化和反序列化
			oos.writeUTF("anxiaolong");
			oos.writeInt(27);
			oos.writeDouble(Math.random());
			oos.flush();
			//逐级新建一个ObjectInputStream对象
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			//ObjectInputStream对象读取对象信息
			System.out.println(ois.readObject());
			System.out.println(ois.readUTF());
			System.out.println(ois.readInt());
			System.out.println(ois.readDouble());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (ois!=null) {
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (oos!=null) {
					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
