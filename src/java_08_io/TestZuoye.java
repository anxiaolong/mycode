package java_08_io;
/**
 * �����ֽ�����ͣ��������͡��������ͣ����໥ת��
 * �ļ��ֽ���FileInputStream FileOutputStream ����ļ�����
 * �ļ��ַ���FileInputReader FileOutputWriter Reader��Writer�����ַ���
 * �������ֽ���BufferedInputStream BufferedOutputStream
 * �����ַ���BufferdReader BufferdWriter
 * �ֽ�������ByteArrayInputStream ByteArrayOutputStream
 * ������DataInputStream DataOutputStream ��װ������ת��Ϊ��������
 * ������ObjectInputStream ObjectOutputStream ��װ������ת��Ϊ�������ͣ�����������Ҫʵ�����л��ӿ�
 * ת����InputStreamReader OutputStreamWriter ʵ���ֽ���ת�ַ���
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestZuoye implements Serializable {//��ʵ�����л���������ת��Ϊ��
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
	
	//��������ת�ֽ����飬�ֽ�����ת�������ͣ�ʹ��DataInputStream��DataOutputStream
	public static void test1() throws IOException {
		int a = 100;
		String s = "anxiaolong";
		boolean b = true;
		//�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeInt(a);
		dos.writeUTF(s);
		dos.writeBoolean(b);
		byte[] array1 = baos.toByteArray();
		dos.close();
		baos.close();
		//������
		ByteArrayInputStream bais = new ByteArrayInputStream(array1);
		DataInputStream dis = new DataInputStream(bais);
		int a1 = dis.readInt();
		String s1 = dis.readUTF();
		boolean b1 = dis.readBoolean();
		System.out.println(a1+" "+s1+" "+b1);
		dis.close();
		bais.close();
	}
	//�������ͺ��ֽ����黥��ת������Ӧ������Ҫʵ��Serializable���л��ӿ�
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
