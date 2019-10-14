package io;
/**
 * ���Զ�������ȡ��д�룬д��Ķ�������Ҫʵ�����л������л�
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
			//���½�һ��ObjectOutputStream����
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			//ObjectOutputStream����д������������ļ�֮ǰ������������ObjectInputStream����ᱨ��
			oos.writeObject(new Date());//д�������Ҫʵ�����л��ͷ����л�
			oos.writeUTF("anxiaolong");
			oos.writeInt(27);
			oos.writeDouble(Math.random());
			oos.flush();
			//���½�һ��ObjectInputStream����
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			//ObjectInputStream�����ȡ������Ϣ
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
