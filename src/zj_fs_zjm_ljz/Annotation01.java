package zj_fs_zjm_ljz;
/**
 * 自定义一个注解，并设置注解内容
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
	
	String[] school() default {"北京大学","成都大学"};
}
