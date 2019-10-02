package cy_class;
/**
 * 递归打印目录层级结构
 */
import java.io.File;

public class TestFile2 {
	public static void main(String[] args) {
		File f1File = new File("D:\\软件安装包");
		test(f1File, 0);
	}
	
	public static void test(File file,int leval) {
		//输出层级
		for (int i = 0; i < leval; i++) {
			System.out.print("-"); //打印层级
		}
		System.out.println(file.getName()); //输出文件名或目录名
		if (file.isDirectory()) {  //判断文件是目录情况
			File[] sFiles = file.listFiles();  //罗列目录中的文件或文件夹
			for (File file2 : sFiles) { //foreach结构，逐个使用数组中元素
				test(file2, leval+1); //递归调用打印目录文件名方法，把文件夹和文件夹内的文件全部打印
			}
		}
	}
}
