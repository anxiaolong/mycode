package java_04_CommonClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class TestFile {
	//file类创建文件
	public static void test1() throws IOException {
		System.out.println(System.getProperty("user.dir")); //eclipse默认user.dir为项目目录
		File f1File = new File("src\\cy_class\\a.txt");
		f1File.createNewFile();
//		File f2File = new File("D:\\a.txt"); //在D盘创建文件
//		f2File.createNewFile();
	}
	//file类常用方法
	public static void test2() throws IOException {
		File f1File = new File("src\\cy_class\\b.txt");
		f1File.createNewFile();
		System.out.println(f1File.exists()); //判断文件是否存在
		System.out.println(f1File.isDirectory()); //判断是否是文件夹
		System.out.println(f1File.isFile()); //判断是否是文件
		System.out.println(new Date(f1File.lastModified())); //最后修改时间
		System.out.println(f1File.length()); //文件大小
		System.out.println(f1File.getName()); //文件名
		System.out.println(f1File.getAbsolutePath()); //绝对路径
	}
	//删除文件
	public static void test3() throws IOException {
		File f1File = new File("src\\cy_class\\b.txt");
		f1File.createNewFile();
//		f1File.delete(); //删除f1File对应的文件
	}
	//mkdir创建目录，目录中间有缺失创建按失败
	public static void test4() {
		File f1File = new File("src\\test\\cy_class\\b.txt");
		System.out.println(f1File.mkdir()); //不存在的目录结构会创建失败
	}
	//mkdirs创建目录，不存在的目录会新建
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
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} else {
			boolean flag1 = f1File.createNewFile();
			if (flag1) {
				System.out.println("创建成功");
			} else {
				System.out.println("创建失败");
			}
		}
		if (f1File.exists()) {
			f1File.renameTo(new File("src\\cy_class\\test.txt")); //renameTo参数是一个新对象
			System.out.println("重命名成功");
		}
	}
}
