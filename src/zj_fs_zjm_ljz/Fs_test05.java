package zj_fs_zjm_ljz;
/**
 * ʹ�÷�����÷�����ȥ�����ʰ�ȫ����ִ��Ч�ʱ���ͨ���ò�3��
 */
import java.lang.reflect.Method;

public class Fs_test05 {
	public static void test1() {
		//��ͨ����getName����
		Fs_User user = new Fs_User();
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000000L; i++) {
			user.getName();
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("��ͨ������ʱ��"+(endTime-startTime));
	}
	
	public static void test2() {
		//����api����getName����
		Class<?> clz = Fs_User.class;
		try {
			Fs_User user = (Fs_User) clz.getConstructor().newInstance();
			Method m = clz.getMethod("getName", null);
			Long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				m.invoke(user, null);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("���������ʱ��"+(endTime-startTime));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void test3() {
		//����api����getName����,��ִ�а�ȫ���ʼ��
		Class<?> clz = Fs_User.class;
		try {
			Fs_User user = (Fs_User) clz.getConstructor().newInstance();
			Method m = clz.getMethod("getName", null);
			m.setAccessible(true);
			Long startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000000000L; i++) {
				m.invoke(user, null);
			}
			Long endTime = System.currentTimeMillis();
			System.out.println("��ִ�а�ȫ�����ʱ��"+(endTime-startTime));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}
}
