package java_02_oop;
/**
 * �ӿڵĶ�̳�
 * �ڲ�����󴴽�
 * �ӿڵ�ʵ��
 * �ӿڳ�Ա����Ĭ�ϣ�public static final
 * �ӿڷ���Ĭ�ϣ�public abstract
 * @author Administrator
 *
 */

public class TestInterface {
	public static void main(String[] args) {
		//�����ڲ���Ķ���
		Cxy c1Cxy = new TestInterface().new Cxy();
		c1Cxy.run();
		c1Cxy.jump();
		c1Cxy.sport();
		c1Cxy.xuexi();
		c1Cxy.age = 27; //���ڲ�����и�ֵ
		
	}
	
	//����һ���ڲ��࣬�̳�Human��ʵ�ֽӿ�Man
	public class Cxy extends Human implements Man  {
		int age;
		public void run() {
			System.out.println("��"+Run.a+"��");
		}
		public void jump() {
			System.out.println("��"+Jump.a+"��");
		}
		public void sport() {
			System.out.println("�˶�");
		}
		public void xuexi() {
			System.out.println("д����");
		}
	}
}

interface Run {
	public static final int a = 1000;
	public abstract void run(); //�ӿڷ�����û��ʵ�֣�Ĭ����public abstract����
}

interface Jump {
	public static final int a = 1;
	public abstract void jump();
}

//�ӿڿ��Զ�̳�
interface Man extends Run,Jump {
	public abstract void sport();
}

class Human {
	public void xuexi() {
		System.out.println("ѧϰ");
	}
}