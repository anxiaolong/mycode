package oop;
/**
 * �������ļ򵥾���
 * @author Administrator
 *
 */
class Computer{
	//����һ�������࣬����һ������Ʒ��
	String brand;
}

public class Stu {
	//field ������ԣ�����ĳ�Ա����
	int id;
	String name;
	int age;
	//Stu�����ĳ�Ա������������һ����Ķ���
	Computer comp;
	
	//Stu�����ķ���
	public void Study() {
		System.out.println("����ѧϰ�ķ���ִ��");
	}
	
	//Stu�����Ĺ��췽������д���Զ�����
	//���췽�������أ�������췽��
	public Stu() {
		super();
	}
	public  Stu(int id,String name) {
		this.id = id; //this��ʾ�����ŵĶ���
		this.name = name;
	}
	public  Stu(String name,int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public static void main(String[] args) {
		Stu stu02 = new Stu(12, "anxiaolong");
		Stu stu03 = new Stu("test", 11);
		
		//������Ĺ��췽��,�½�һ��Stu����stu1
		Stu stu1 = new Stu();
		//��stu1��������name��ֵ
		stu1.name = "anxiaolong";
		//�½�һ��Computer����
		Computer comp1 = new Computer();
		//����comp1������������ֵ
		comp1.brand = "thinkpad";
		//����stu1������������ֵ
		stu1.comp = comp1;
		//����ʵ���ϣ���һ���ڴ��ַ��oop.Computer@15db9742
		System.out.println(comp1);
		//��Ϊ����stu1���߱�Stu������ȫ������
		stu1.Study();
	}
}
