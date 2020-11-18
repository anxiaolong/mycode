package java_08_io;
/**
 * 测试数据流，写入顺序和读取顺序必须一致
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataInputStream {
	public static void main(String[] args) {
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		String des = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		DataInputStream dis = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);
			dis = new DataInputStream(new BufferedInputStream(fis));
			dos = new DataOutputStream(new BufferedOutputStream(fos));
			dos.writeChar('a');
			dos.writeBoolean(true);
			dos.writeDouble(Math.random());
			dos.writeInt(27);
			dos.writeUTF("测试下");
			dos.flush();//刷新缓存
			System.out.println(dis.readChar());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readDouble());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (dis!=null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (dos!=null) {
					dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
