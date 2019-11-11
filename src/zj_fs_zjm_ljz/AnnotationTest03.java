package zj_fs_zjm_ljz;
/**
 * 使用反射读取信息，并处理注解
 */
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationTest03 {
	public static void main(String[] args) {
		try {
			Class clz = Class.forName("zj_fs_zjm_ljz.AnnotationStudent");
			
			//获得类所有有效注解
			Annotation[] annotations = clz.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}
			
			//获得类指定的注解(表名)
			Annotation02 a2 = (Annotation02) clz.getAnnotation(Annotation02.class);
			System.out.println(a2.value());
			
			//获得属性的注解(表结构字段)
			Field f = clz.getDeclaredField("name");
			Annotation03 a3 = f.getAnnotation(Annotation03.class);
			System.out.println(a3.columnName()+"--"+a3.type()+"--"+a3.length());
			
			//根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成相关的表
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
