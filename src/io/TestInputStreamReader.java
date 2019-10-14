package io;
/**
 * 测试InputStreamReader OutputStreamWriter
 * 用于将字节流对象转化为字符流对象
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestInputStreamReader {
	public static void main(String[] args) {
		//BufferReader和BufferWrtier属于缓冲字符流
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//OutputStreamWriter把输出字节流对象System.out，转化为字符流对象osw
			OutputStreamWriter osw = new OutputStreamWriter(System.out);
			bw = new BufferedWriter(osw);//包装为缓冲字符流
			//InputStreamReader把输入字节流System.in，转化为字符流对象isr
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);//包装为缓冲字符流
			String str = br.readLine();//新建一个字符串，赋值为读取字符流br的一行字符
			while (!"exit".equals(str)) {
				bw.write(str);//控制台输出str这个字符串
				bw.newLine();//换行
				bw.flush();//刷新缓存
				str = br.readLine();//读取下一行的，并赋值给str，循环迭代的条件
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (br!=null) {
					br.close();
				}
				System.out.println("br关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (bw!=null) {
					bw.close();
				}
				System.out.println("bw关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
