package java_08_io;
/**
 * 测试字节数组和（基本类型、引用类型）的相互转化
 * 文件字节流FileInputStream FileOutputStream 针对文件操作
 * 文件字符流FileInputReader FileOutputWriter Reader和Writer便是字符流
 * 缓冲流字节流BufferedInputStream BufferedOutputStream
 * 缓冲字符流BufferdReader BufferdWriter
 * 字节数组流ByteArrayInputStream ByteArrayOutputStream
 * 数据流DataInputStream DataOutputStream 包装流，可转化为基本类型
 * 对象流ObjectInputStream ObjectOutputStream 包装流，可转化为引用类型，引用类型需要实现序列化接口
 * 转换流InputStreamReader OutputStreamWriter 实现字节流转字符流
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestZuoye implements Serializable {//不实现序列化，对象不能转化为流
	int age;
	String name;
	
	public TestZuoye(int age,String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
		public String toString() {
			return this.name+" "+this.age;
		}
	
	//基本类型转字节数组，字节数组转基本类型，使用DataInputStream和DataOutputStream
	public static void test1() throws IOException {
		int a = 100;
		String s = "anxiaolong";
		boolean b = true;
		//输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(a);
		dos.writeUTF(s);
		dos.writeBoolean(b);
		byte[] array1 = baos.toByteArray();
		dos.close();
		baos.close();
		//输入流
		ByteArrayInputStream bais = new ByteArrayInputStream(array1);
		DataInputStream dis = new DataInputStream(bais);
		int a1 = dis.readInt();
		String s1 = dis.readUTF();
		boolean b1 = dis.readBoolean();
		System.out.println(a1+" "+s1+" "+b1);
		dis.close();
		bais.close();
	}
	//引用类型和字节数组互相转化，对应的类需要实现Serializable序列化接口
	public static void test2() throws IOException, ClassNotFoundException {
		TestZuoye t1 = new TestZuoye(27, "anxiaolong");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(t1);
		byte[] b1 = baos.toByteArray();
		oos.close();
		baos.close();
		ByteArrayInputStream bais = new ByteArrayInputStream(b1);
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println(ois.readObject());
		ois.close();
		bais.close();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		test1();
		test2();
	}
}
