package cy_class;
/**
 * �ݹ��ӡĿ¼�㼶�ṹ
 */
import java.io.File;

public class TestFile2 {
	public static void main(String[] args) {
		File f1File = new File("D:\\�����װ��");
		test(f1File, 0);
	}
	
	public static void test(File file,int leval) {
		//����㼶
		for (int i = 0; i < leval; i++) {
			System.out.print("-"); //��ӡ�㼶
		}
		System.out.println(file.getName()); //����ļ�����Ŀ¼��
		if (file.isDirectory()) {  //�ж��ļ���Ŀ¼���
			File[] sFiles = file.listFiles();  //����Ŀ¼�е��ļ����ļ���
			for (File file2 : sFiles) { //foreach�ṹ�����ʹ��������Ԫ��
				test(file2, leval+1); //�ݹ���ô�ӡĿ¼�ļ������������ļ��к��ļ����ڵ��ļ�ȫ����ӡ
			}
		}
	}
}
