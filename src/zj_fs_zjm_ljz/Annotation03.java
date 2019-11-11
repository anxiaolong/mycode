package zj_fs_zjm_ljz;
/**
 * 这个注解主要用于AnnotationStudent类，标注成员变量再数据库中位置
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
