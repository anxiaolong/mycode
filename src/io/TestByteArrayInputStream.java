package io;
/**
 * �����ֽ��������������ֽ�����ֱ�ӽ���ת��ʱ����Ҫ�õ�
 * @author Administrator
 *
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestByteArrayInputStream {
	public static void main(String[] args) {
		byte[] t1 = "anxiaolong".getBytes();//���ַ���ת��Ϊһ���ֽ�����
		StringBuilder desString = new StringBuilder();//�½�һ���ɱ���ַ����������ڽ����ַ�
		ByteArrayInputStream src = new ByteArrayInputStream(t1);
		try {
			int temp = 0;
			int num = 0;
			while ((temp=src.read())!=-1) {
				desString.append((char)temp);
				num++;
			}
			System.out.println(desString);
			System.out.println("��ȡ�ֽ�����"+num);
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
