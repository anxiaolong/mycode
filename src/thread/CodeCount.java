package thread;
/**
 * 统计/mycode/src/下java文件中写了多少行代码
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeCount {
	public static void main(String[] args) throws IOException {
		String src = "D:\\eclipse-workspace\\mycode\\src";
		File javaFile = new File(src);
		File[] f = javaFile.listFiles();
		int count = 0;
		for (int i = 0; i < f.length; i++) {
//			System.out.println(f[i]);
			if (f[i].isDirectory()) {
				File[] f1 = f[i].listFiles();
				for (int j = 0; j < f1.length; j++) {
//					System.out.println(f1[j]);
					if (f1[j].isFile()&&f1[j].getName().endsWith("java")) {
						FileInputStream fis = new FileInputStream(f1[j]);
						InputStreamReader isr = new InputStreamReader(fis);
						BufferedReader br = new BufferedReader(isr);
						int temp = 0;
						while ((temp=br.read())!=-1) {
							br.readLine();
							count++;
						}
						
					}
				}
			}
		}
		System.out.println("当前代码量："+count+"行");
	}
}
