package java_12_zj_fs_zjm_ljz;
/**
 * 测试javassist操作类、属性、方法
 */
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class Javassist_test02 {
	//处理类的基本用法
	public static void test01() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(cc.getName());//获取类名
		System.out.println(cc.getSimpleName());//获取简要类名
		System.out.println(cc.getSuperclass());//获得父类
		System.out.println(cc.getInterfaces());//获得接口
	}
	
	//使用javassist给类创建新方法
	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType }, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"test method\");return $1+$2;}");
		cc.addMethod(m);
		//通过反射调用新生成的方法
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method method = clz.getDeclaredMethod("add", int.class,int.class);
		Object result = method.invoke(obj, 100,345);
		System.out.println(result);
	}
	
	//操作已有的方法，添加新代码
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtMethod cm = cc.getDeclaredMethod("setId",new CtClass[] {CtClass.intType});
		cm.insertBefore("System.out.println($1+\" test\");");//方法体之前插入代码
		cm.insertAt(18, "System.out.println(\"插入18行\");");//代码行号之前插入代码
		cm.insertAfter("System.out.println(\"方法体之后插入的代码\");");//方法体之后插入代码
		
		//通过反射调用新生成的方法
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method method = clz.getDeclaredMethod("setId", int.class);
		method.invoke(obj, 444);
	}
	
	//javassist操作属性
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtField f1 = new CtField(CtClass.intType, "testid", cc);
		f1.setModifiers(Modifier.PUBLIC);
		cc.addField(f1);
		
		//增加响应的set和get方法
		cc.addMethod(CtNewMethod.getter("getTestid", f1));
		cc.addMethod(CtNewMethod.setter("setTestid", f1));
		
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method m1 = clz.getDeclaredMethod("setTestid", int.class);
		m1.invoke(obj, 27);
	}
	
	//操作构造方法
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtConstructor[] cs = cc.getConstructors();
		for (CtConstructor ctConstructor : cs) {
			System.out.println(ctConstructor.getLongName());
		}
	}
	
	public static void main(String[] args) throws Exception {
		test05();
	}
}
