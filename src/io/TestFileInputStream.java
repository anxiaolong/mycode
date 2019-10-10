package io;
/**
 * 测试FileInputStream
 */
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		FileInputStream f1 = null;//定义一个空对象，方便后面finally中使用，否则无法关闭
		try {
			//创建一个文件输入流对象，指定文件位置
			f1 = new FileInputStream("D:\\eclipse-workspace\\mycode\\src\\cy_class\\a.txt");
			StringBuilder s1 = new StringBuilder();//创建一个字符串用来接受读取的字符
			int temp = 0;
			while ((temp=f1.read())!=-1) {
				System.out.println(temp); //read()方法读取的是字符的ascii码
				s1.append((char)temp);//所以这里需要转为char，然后加入到字符串中
			}
//			System.out.println(temp); //循环读取完了之后temp=-1
			System.out.println(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//finally一定会执行，所以关闭流对象放里面
		finally {
			try {
				//加判断是为了保证再异常下f1.close()也会执行
				if (f1!=null) {
					f1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
