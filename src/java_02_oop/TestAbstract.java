package java_02_oop;
/**
 * abstract���ε��࣬����new
 * abstract���εķ�����������������д
 * abstract�������࣬������abstract����
 * @author Administrator
 *
 */
public class TestAbstract {
	public static void main(String[] args) {
//		TestAbstract1 testAbstract1 = new TestAbstract1(); //abstract���ε��಻��new����
		TestAbstract2 t1 = new TestAbstract2();
		t1.run();
	}
}

abstract class TestAbstract1 { //��abstract�������࣬������abstract����
	abstract void run(); //abstract ���εķ���û��ʵ�ֵ�����
}

class TestAbstract2 extends TestAbstract1 {
	//�̳и���abstract����������Ҫ��д
	public void run() { 
		System.out.println("��");
	}
}