package java_12_zj_fs_zjm_ljz;
/**
 * ����javassist�����ࡢ���ԡ�����
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
	//������Ļ����÷�
	public static void test01() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		
		System.out.println(cc.getName());//��ȡ����
		System.out.println(cc.getSimpleName());//��ȡ��Ҫ����
		System.out.println(cc.getSuperclass());//��ø���
		System.out.println(cc.getInterfaces());//��ýӿ�
	}
	
	//ʹ��javassist���ഴ���·���
	public static void test02() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType,CtClass.intType }, cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"test method\");return $1+$2;}");
		cc.addMethod(m);
		//ͨ��������������ɵķ���
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method method = clz.getDeclaredMethod("add", int.class,int.class);
		Object result = method.invoke(obj, 100,345);
		System.out.println(result);
	}
	
	//�������еķ���������´���
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtMethod cm = cc.getDeclaredMethod("setId",new CtClass[] {CtClass.intType});
		cm.insertBefore("System.out.println($1+\" test\");");//������֮ǰ�������
		cm.insertAt(18, "System.out.println(\"����18��\");");//�����к�֮ǰ�������
		cm.insertAfter("System.out.println(\"������֮�����Ĵ���\");");//������֮��������
		
		//ͨ��������������ɵķ���
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method method = clz.getDeclaredMethod("setId", int.class);
		method.invoke(obj, 444);
	}
	
	//javassist��������
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("zj_fs_zjm_ljz.Javassist_Emp");
		
		CtField f1 = new CtField(CtClass.intType, "testid", cc);
		f1.setModifiers(Modifier.PUBLIC);
		cc.addField(f1);
		
		//������Ӧ��set��get����
		cc.addMethod(CtNewMethod.getter("getTestid", f1));
		cc.addMethod(CtNewMethod.setter("setTestid", f1));
		
		Class clz = cc.toClass();
		Object obj = clz.newInstance();
		Method m1 = clz.getDeclaredMethod("setTestid", int.class);
		m1.invoke(obj, 27);
	}
	
	//�������췽��
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
