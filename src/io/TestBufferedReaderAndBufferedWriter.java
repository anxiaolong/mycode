package io;
/**
 * ���еĻ�����������ֱ��ʹ�ã���Ҫ�Ȱ�װ��Ӧ��������ʹ��
 * ʹ��BufferedReader��BufferedWriter��ȡ��д���ı��ļ�
 * readLine()���ܵ����ַ�����newLine()��������д��һ��֮����
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
				bdes.write(temp);//д���ȡ��һ������
				bdes.newLine();//д��һ��֮����Ҫ����
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
