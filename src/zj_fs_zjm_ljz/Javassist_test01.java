package zj_fs_zjm_ljz;
/**
 * ����ʹ��javassist�����ֽ�������һ��class
 */
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

public class Javassist_test01 {
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("zj_fs_zjm_ljz.Javassist_Emp");
		
		//��������
		CtField f1 = CtField.make("private int empno;", cc);
		CtField f2 = CtField.make("private int name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		//��������
		CtMethod m1 = CtMethod.make("public void getEmpno(){return empno;}", cc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//��ӹ�����
		CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.empno=empno;this.name=name;}");
		cc.addConstructor(constructor);
		
		cc.writeFile("C:\\");
		System.out.println("������ɹ�");
	}
}
