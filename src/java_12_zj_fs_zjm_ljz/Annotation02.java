package java_12_zj_fs_zjm_ljz;
/**
 * �Զ���һ��ע�Ⲣ������һ������һ��ʹ��value
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
