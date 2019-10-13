package io;
/**
 * 测试字节数组流，流和字节数组直接进行转化时候需要用到
 * @author Administrator
 *
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestByteArrayInputStream {
	public static void main(String[] args) {
		byte[] t1 = "anxiaolong".getBytes();//把字符串转化为一个字节数组
		StringBuilder desString = new StringBuilder();//新建一个可变的字符串对象，用于接收字符
		ByteArrayInputStream src = new ByteArrayInputStream(t1);
		try {
			int temp = 0;
			int num = 0;
			while ((temp=src.read())!=-1) {
				desString.append((char)temp);
				num++;
			}
			System.out.println(desString);
			System.out.println("读取字节数："+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (src!=null) {
					src.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}
