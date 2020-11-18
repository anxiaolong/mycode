package java_12_zj_fs_zjm_ljz;
/**
 * 自定义一个注解并，设置一个参数一般使用value
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation02 {
	String value();
}
