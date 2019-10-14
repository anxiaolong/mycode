package io;
/**
 * ����InputStreamReader OutputStreamWriter
 * ���ڽ��ֽ�������ת��Ϊ�ַ�������
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestInputStreamReader {
	public static void main(String[] args) {
		//BufferReader��BufferWrtier���ڻ����ַ���
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//OutputStreamWriter������ֽ�������System.out��ת��Ϊ�ַ�������osw
			OutputStreamWriter osw = new OutputStreamWriter(System.out);
			bw = new BufferedWriter(osw);//��װΪ�����ַ���
			//InputStreamReader�������ֽ���System.in��ת��Ϊ�ַ�������isr
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);//��װΪ�����ַ���
			String str = br.readLine();//�½�һ���ַ�������ֵΪ��ȡ�ַ���br��һ���ַ�
			while (!"exit".equals(str)) {
				bw.write(str);//����̨���str����ַ���
				bw.newLine();//����
				bw.flush();//ˢ�»���
				str = br.readLine();//��ȡ��һ�еģ�����ֵ��str��ѭ������������
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
				System.out.println("br�ر�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (bw!=null) {
					bw.close();
				}
				System.out.println("bw�ر�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
