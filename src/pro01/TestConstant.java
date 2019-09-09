package pro01;
import org.omg.PortableInterceptor.AdapterManagerIdHelper;

/**
 * 常量用final修饰，被初始化之后不能再修改值
 * @author Administrator
 *
 */
public class TestConstant {
	public static void main(String[] args) {
		final int age = 18;
//		age =20; 修改常量值会异常
		
	}
}