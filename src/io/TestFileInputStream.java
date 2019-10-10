package io;
/**
 * ����FileInputStream
 */
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		FileInputStream f1 = null;//����һ���ն��󣬷������finally��ʹ�ã������޷��ر�
		try {
			//����һ���ļ�����������ָ���ļ�λ��
			f1 = new FileInputStream("D:\\eclipse-workspace\\mycode\\src\\cy_class\\a.txt");
			StringBuilder s1 = new StringBuilder();//����һ���ַ����������ܶ�ȡ���ַ�
			int temp = 0;
			while ((temp=f1.read())!=-1) {
				System.out.println(temp); //read()������ȡ�����ַ���ascii��
				s1.append((char)temp);//����������ҪתΪchar��Ȼ����뵽�ַ�����
			}
//			System.out.println(temp); //ѭ����ȡ����֮��temp=-1
			System.out.println(s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//finallyһ����ִ�У����Թر������������
		finally {
			try {
				//���ж���Ϊ�˱�֤���쳣��f1.close()Ҳ��ִ��
				if (f1!=null) {
					f1.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
