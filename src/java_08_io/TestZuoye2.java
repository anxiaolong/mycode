package java_08_io;
/**
 * 测试复制文件夹及内容 到另外一个文件夹
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
	//使用FileUtils实现文件夹及内容拷贝
	public static void copy1() throws IOException {
		String srcDir = "D:\\java相关\\commons-io";
		String destDir = "D:\\java相关\\commons-io2";
		File f1File = new File(srcDir);
		File f2File = new File(destDir);
		FileUtils.copyDirectory(f1File, f2File);
	}
	//使用FileUtils实现逐行读取文件内容，并存入list，并输出
	public static void test1() throws IOException {
		List<String> l1 = new ArrayList<String>();
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		l1 = FileUtils.readLines(new File(src), "gbk");
		for (String tt : l1) {
			System.out.println(tt);
		}
	}
	//使用流和迭代器实现逐行读取存入list，并遍历
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
	//文件复制
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
	//复制文件夹及里面的内容
	/*1.调用copyDirectory(String src,String des)过程中，也调用了copyFile(File src,File des)复制文件
	 * 2.文件是目录，递归调用copyDirectory(String src,String des)，一层一层的新建目录，再复制文件
	 * 3.遍历完成之后，目录创建完，文件也复制完
	 * */
	public static void copyDirectory(String src,String des) throws IOException {
		File f1 = new File(src);
		File f2 = new File(des);
		//检查源文件夹是否存在
		if (!f1.exists()||!f1.isDirectory()) {
			System.out.println("不存在的目录");
			return;
		}
		//判断目标文件夹是否存在，不存在就创建
		if (!f2.exists()) {
			f2.mkdirs();
		}
		//遍历源文件夹
		File[] af = f1.listFiles();
		for (int i = 0; i < af.length; i++) {
			//如何af[i]是文件不是文件夹，直接复制文件到新的文件
			if (af[i].isFile()) {
				File Fdes = new File(des, af[i].getName());//目标文件夹路径+文件名
				copyFile(af[i], Fdes);
			}
			//如果af[i]是文件夹，递归调用复制文件夹的方法
			if (af[i].isDirectory()) {
				String srctt = src + "\\" + af[i].getName();
				String destt = des + "\\" + af[i].getName();
				copyDirectory(srctt, destt);//因为使用了递归，所以每次递归src和des都不一样
			}
		}
	}
	public static void main(String[] args) throws IOException {
//		copyDirectory("D:\\java相关\\commons-io", "D:\\test1111");
	}	
}
