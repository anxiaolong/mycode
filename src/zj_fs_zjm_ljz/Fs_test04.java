package zj_fs_zjm_ljz;
/**
 * 使用反射获取泛型参数和泛型返回值的具体类型
 */
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.lang.reflect.*;

public class Fs_test04 {
	
	public void test1(Map<String, Fs_User> map,List<Fs_User> list) {
		System.out.println("test1_run");
	}
	
	public Map<Integer, Fs_User> test2() {
		System.out.println("test2_run");
		return null;
	}
	
	public static void main(String[] args) {
		try {
			//获取方法中泛型参数信息
			Method m = Fs_test04.class.getMethod("test1", Map.class,List.class);
			Type[] t = m.getGenericParameterTypes();
			for (Type type : t) {
				System.out.println("#"+type);
				if (type instanceof ParameterizedType) {
					Type[] genericTypes = ((ParameterizedType)type).getActualTypeArguments();
					for (Type type2 : genericTypes) {
						System.out.println("泛型类型："+type2);
					}
				}
			}
			
			//获得指定方法返回值泛型信息
			Method m2 = Fs_test04.class.getMethod("test2", null);
			Type returnType = m2.getGenericReturnType();
			System.out.println(returnType);
			if (returnType instanceof ParameterizedType) {
				Type[] genericTypes2 = ((ParameterizedType)returnType).getActualTypeArguments();
				for (Type type2 : genericTypes2) {
					System.out.println(type2);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
