package java_12_zj_fs_zjm_ljz;
/**
 * ʹ�÷��乹����󣬲������ԣ����÷���
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fs_test03 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		
		try {
			Class<?> clz = Class.forName(path);
			
			//ͨ������API���ù��췽�����������
			Fs_User user = (Fs_User)clz.newInstance();//�൱�ڵ��ÿչ���
			System.out.println(user);
			
			Constructor<Fs_User> constructor = (Constructor<Fs_User>) clz.getConstructor(int.class,String.class,int.class);
			Fs_User user2 = constructor.newInstance(11,"anxiaolong",27);//��ȡ�вι��죬��������
			System.out.println(user2.getName());
			
			//ͨ������API������ͨ����
			Method m1 = clz.getDeclaredMethod("setName", String.class);
			m1.invoke(user2, "testanxiaolong");//��������user2�ı���
			System.out.println(user2.getName());
			
			//ͨ������APIֱ�Ӳ�������
			Field f = clz.getDeclaredField("name");
			f.setAccessible(true);//������ȫ���
			f.set(user2, "test0001");
			System.out.println(f.get(user2));//ͨ������ֱ�Ӷ�ȡ����ֵ
			System.out.println(user2.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
