package java_08_io;
/**
 * ���Ը����ļ��м����� ������һ���ļ���
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestZuoye2 {
	//ʹ��FileUtilsʵ���ļ��м����ݿ���
	public static void copy1() throws IOException {
		String srcDir = "D:\\java���\\commons-io";
		String destDir = "D:\\java���\\commons-io2";
		File f1File = new File(srcDir);
		File f2File = new File(destDir);
		FileUtils.copyDirectory(f1File, f2File);
	}
	//ʹ��FileUtilsʵ�����ж�ȡ�ļ����ݣ�������list�������
	public static void test1() throws IOException {
		List<String> l1 = new ArrayList<String>();
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		l1 = FileUtils.readLines(new File(src), "gbk");
		for (String tt : l1) {
			System.out.println(tt);
		}
	}
	//ʹ�����͵�����ʵ�����ж�ȡ����list��������
	public static void test2() throws IOException {
		List<String> l1 = new ArrayList<String>();
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		FileInputStream fis = new FileInputStream(src);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		int temp = 0;
		while ((temp=br.read())!=-1) {
			l1.add(br.readLine());
		}
		for (Iterator<String> i1 = l1.iterator();i1.hasNext();) {
			String s = i1.next();
			System.out.println(s);
		}
	}
	//�ļ�����
	public static void copyFile(File src,File des) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(des);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int temp = 0;
		while ((temp=bis.read())!=-1) {
			bos.write(temp);
		}
		bos.close();
		bis.close();
		fos.close();
		fis.close();
	}
	//�����ļ��м����������
	/*1.����copyDirectory(String src,String des)�����У�Ҳ������copyFile(File src,File des)�����ļ�
	 * 2.�ļ���Ŀ¼���ݹ����copyDirectory(String src,String des)��һ��һ����½�Ŀ¼���ٸ����ļ�
	 * 3.�������֮��Ŀ¼�����꣬�ļ�Ҳ������
	 * */
	public static void copyDirectory(String src,String des) throws IOException {
		File f1 = new File(src);
		File f2 = new File(des);
		//���Դ�ļ����Ƿ����
		if (!f1.exists()||!f1.isDirectory()) {
			System.out.println("�����ڵ�Ŀ¼");
			return;
		}
		//�ж�Ŀ���ļ����Ƿ���ڣ������ھʹ���
		if (!f2.exists()) {
			f2.mkdirs();
		}
		//����Դ�ļ���
		File[] af = f1.listFiles();
		for (int i = 0; i < af.length; i++) {
			//���af[i]���ļ������ļ��У�ֱ�Ӹ����ļ����µ��ļ�
			if (af[i].isFile()) {
				File Fdes = new File(des, af[i].getName());//Ŀ���ļ���·��+�ļ���
				copyFile(af[i], Fdes);
			}
			//���af[i]���ļ��У��ݹ���ø����ļ��еķ���
			if (af[i].isDirectory()) {
				String srctt = src + "\\" + af[i].getName();
				String destt = des + "\\" + af[i].getName();
				copyDirectory(srctt, destt);//��Ϊʹ���˵ݹ飬����ÿ�εݹ�src��des����һ��
			}
		}
	}
	public static void main(String[] args) throws IOException {
//		copyDirectory("D:\\java���\\commons-io", "D:\\test1111");
	}	
}
