package java_12_zj_fs_zjm_ljz;
/**
 * ����ͨ�������ȡ���������ԡ�������������
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fs_test02 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		try {
			Class<?> clz = Class.forName(path);
			
			//�����ȡ�������
			System.out.println(clz.getName());//����+����
			System.out.println(clz.getSimpleName());//��ȡ����
			
			
			//�����ȡ������Ϣ
//			Field[] fields = clz.getFields();//ֻ�ܻ�ȡpublic���ε�����
			Field[] fields = clz.getDeclaredFields();//��ȡ��������
			for (Field field : fields) {
				System.out.println("���ԣ�"+field);
			}
			
			//�����ȡ��ķ�����Ϣ
			Method[] methods = clz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("������"+method);
			}
			Method m1 = clz.getDeclaredMethod("getName", null);
			//�в�����Ҫ���ݲ������Ͷ�Ӧ��class����
			Method m2 = clz.getDeclaredMethod("setName", String.class);
			Method m3 = clz.getDeclaredMethod("setAge", int.class);
			System.out.println(m1);
			System.out.println(m2);
			System.out.println(m3);
			
			//��ȡ��������Ϣ
			Constructor[] constructors = clz.getConstructors();
			for (Constructor constructor : constructors) {
				System.out.println(constructor);
			}
			//��ȡ�вι���
			Constructor<?> constructor = clz.getConstructor(int.class,String.class,int.class);
			System.out.println(constructor);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
