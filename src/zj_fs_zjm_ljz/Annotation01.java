package zj_fs_zjm_ljz;
/**
 * �Զ���һ��ע�⣬������ע������
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation01 {
	String studentName() default "";
	int age() default 0;
	int id() default -1;
	
	String[] school() default {"������ѧ","�ɶ���ѧ"};
}
