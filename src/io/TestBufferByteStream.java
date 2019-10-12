package io;
/**
 * 测试缓冲字节流复制mp3文件
 * BufferedInputStream
 * BufferedOutputStream
 * 关闭流，需要遵循后开先关的顺序
普通字节流用时：21356
缓冲字节流用时：214
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferByteStream {
	
	public static void main(String[] args) {
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\杀猪刀.mp3";
		String des1 = "D:\\eclipse-workspace\\mycode\\src\\io\\杀猪刀1.mp3";
		String des2 = "D:\\eclipse-workspace\\mycode\\src\\io\\杀猪刀2.mp3";
		long time1 = System.currentTimeMillis();
//		test1(src, des1);
		long time2 = System.currentTimeMillis();
		System.out.println("普通字节流用时："+(time2-time1));
		long time3 = System.currentTimeMillis();
//		test2(src, des2);
		long time4 = System.currentTimeMillis();
		System.out.println("缓冲字节流用时："+(time4-time3));
	}
	
	//使用普通字节流复制MP3文件
	public static void test1(String src,String des) {
		FileInputStream src1 = null;
		FileOutputStream des1 = null;
		try {
			src1 = new FileInputStream(src);
			des1 = new FileOutputStream(des);
			int temp = 0;
			while ((temp=src1.read())!=-1) {
				des1.write(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (src1!=null) {
					src1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (des1!=null) {
					des1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//使用缓冲字节流复制
	public static void test2(String src,String des) {
		BufferedInputStream src1 = null;
		BufferedOutputStream des1 = null;
		FileInputStream src2 = null;
		FileOutputStream des2 = null;
		try {
			src2 = new FileInputStream(src);
			des2 = new FileOutputStream(des);
			src1 = new BufferedInputStream(src2);
			des1 = new BufferedOutputStream(des2);
			int temp = 0;
			while ((temp=src1.read())!=-1) {
				des1.write(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//关闭流，需要遵循后开先关的顺序
		finally {
			try {
				if (des1!=null) {
					des1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (src1!=null) {
					src1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (des2!=null) {
					des2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (src2!=null) {
					src2.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
