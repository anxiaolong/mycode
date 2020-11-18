package java_12_zj_fs_zjm_ljz;
/**
 * ��class�ļ�����ȡ�����ܴ���
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ljz_Encryption {
	public static void main(String[] args) {
		Encryption("C:/test/HelloWorld.class", "C:/test/temp/HelloWorld.class");
	}
	
	public static void Encryption(String src,String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null; 
		
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			int temp = -1;
			while ((temp=fis.read())!=-1) {
				fos.write(temp^0xff); //����ȥ������
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
