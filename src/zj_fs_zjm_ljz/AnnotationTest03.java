package zj_fs_zjm_ljz;
/**
 * ʹ�÷����ȡ��Ϣ��������ע��
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationTest03 {
	public static void main(String[] args) {
		try {
			Class clz = Class.forName("zj_fs_zjm_ljz.AnnotationStudent");
			
			//�����������Чע��
			Annotation[] annotations = clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//�����ָ����ע��(����)
			Annotation02 a2 = (Annotation02) clz.getAnnotation(Annotation02.class);
			System.out.println(a2.value());
			
			//������Ե�ע��(��ṹ�ֶ�)
			Field f = clz.getDeclaredField("name");
			Annotation03 a3 = f.getAnnotation(Annotation03.class);
			System.out.println(a3.columnName()+"--"+a3.type()+"--"+a3.length());
			
			//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL�������ݿ���������صı�
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
