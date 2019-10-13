package io;
/**
 * 所有的缓冲流都不能直接使用，需要先包装对应的流才能使用
 * 使用BufferedReader和BufferedWriter读取和写入文本文件
 * readLine()接受的是字符串和newLine()方法用于写完一行之后换行
 * @author Administrator
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedReaderAndBufferedWriter {
	public static void main(String[] args) {
		String src = "D:\\eclipse-workspace\\mycode\\src\\io\\test.txt";
		String des = "D:\\eclipse-workspace\\mycode\\src\\io\\test_copy.txt";
		FileReader fsrc = null;
		FileWriter fdes = null;
		BufferedReader bsrc = null;
		BufferedWriter bdes = null;
		try {
			fsrc = new FileReader(src);
			fdes = new FileWriter(des);
			bsrc = new BufferedReader(fsrc);
			bdes = new BufferedWriter(fdes);
			String temp = "";
			while ((temp=bsrc.readLine())!=null) {
				bdes.write(temp);//写入读取的一行数据
				bdes.newLine();//写了一行之后需要换行
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (bdes!=null) {
					bdes.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bsrc!=null) {
					bsrc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fdes!=null) {
					fdes.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fsrc!=null) {
					fsrc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
