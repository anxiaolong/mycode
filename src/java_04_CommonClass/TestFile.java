package java_04_CommonClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class TestFile {
	//file�ഴ���ļ�
	public static void test1() throws IOException {
		System.out.println(System.getProperty("user.dir")); //eclipseĬ��user.dirΪ��ĿĿ¼
		File f1File = new File("src\\cy_class\\a.txt");
		f1File.createNewFile();
//		File f2File = new File("D:\\a.txt"); //��D�̴����ļ�
//		f2File.createNewFile();
	}
	//file�ೣ�÷���
	public static void test2() throws IOException {
		File f1File = new File("src\\cy_class\\b.txt");
		f1File.createNewFile();
		System.out.println(f1File.exists()); //�ж��ļ��Ƿ����
		System.out.println(f1File.isDirectory()); //�ж��Ƿ����ļ���
		System.out.println(f1File.isFile()); //�ж��Ƿ����ļ�
		System.out.println(new Date(f1File.lastModified())); //����޸�ʱ��
		System.out.println(f1File.length()); //�ļ���С
		System.out.println(f1File.getName()); //�ļ���
		System.out.println(f1File.getAbsolutePath()); //����·��
	}
	//ɾ���ļ�
	public static void test3() throws IOException {
		File f1File = new File("src\\cy_class\\b.txt");
		f1File.createNewFile();
//		f1File.delete(); //ɾ��f1File��Ӧ���ļ�
	}
	//mkdir����Ŀ¼��Ŀ¼�м���ȱʧ������ʧ��
	public static void test4() {
		File f1File = new File("src\\test\\cy_class\\b.txt");
		System.out.println(f1File.mkdir()); //�����ڵ�Ŀ¼�ṹ�ᴴ��ʧ��
	}
	//mkdirs����Ŀ¼�������ڵ�Ŀ¼���½�
	public static void test5() {
		File f1File = new File("src\\cy_class\\testFile\\b.txt");
		System.out.println(f1File.mkdirs()); 
	}
	public static void main(String[] args) throws IOException {
		File f1File = new File("src\\cy_class\\b.txt");
		boolean a = f1File.exists();
		if (a) {
			boolean flag = f1File.delete();
			if (flag) {
				System.out.println("ɾ���ɹ�");
			} else {
				System.out.println("ɾ��ʧ��");
			}
		} else {
			boolean flag1 = f1File.createNewFile();
			if (flag1) {
				System.out.println("�����ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
		}
		if (f1File.exists()) {
			f1File.renameTo(new File("src\\cy_class\\test.txt")); //renameTo������һ���¶���
			System.out.println("�������ɹ�");
		}
	}
}
