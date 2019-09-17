package oop;
/**
 * ���Զ�̬�Ͷ������͵�ǿ��ת��
 * @author Administrator
 *
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		Animal a1Animal = new Dog(); //��������ã�ָ������
		Animal a2Animal = new Cat(); 
		a1Animal.Jiao(); 
		a2Animal.Jiao();
//		a1Animal.kanMen(); //�޷��������������������ֻ�ܵ�����д�ķ���
		Dog dog1Dog = (Dog)(a1Animal);
		System.out.println(a1Animal instanceof Dog);
		System.out.println(a1Animal instanceof Cat); //����ת�ͣ�ʹ��instanceof�����ж��Ƿ���Ŀ������������
//		Cat cat1Cat = (Cat)(a1Animal); //a1Animal������ָ��dog��ǿתδcat���쳣
		dog1Dog.kanMen(); //תδdog֮�󣬼��ɵ���dog�ķ���д�ķ���
	}
}

class Animal {
	
	public void Jiao() {
		System.out.println("��");
	}
}

class Dog extends Animal {
	
	@Override
	public void Jiao() {		
		System.out.println("������");;
	}
	
	public void kanMen() {
		System.out.println("����");
	}
}

class Cat extends Animal {
	@Override
	public void Jiao() {
		System.out.println("������");
	}
}