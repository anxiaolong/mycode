package zj_fs_zjm_ljz;
/**
 * ���ע����Ҫ����AnnotationStudent�࣬��ע��Ա���������ݿ���λ��
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation03 {
	String columnName();
	String type();
	int length();
}
