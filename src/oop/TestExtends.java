package oop;

//δextends���� Ĭ�϶��̳�object��
public class TestExtends {
	public static void main(String[] args) {
		Student916 stu1 = new Student916("anxiaolong", 27, "201110412121");
		stu1.zouLu(); //�̳��˸���ķ�������ֱ��ʹ��
		stu1.paoBu(); //��дoverrides �˸���ķ���
		People p1 = new People();
		System.out.println(stu1 instanceof People); //instanceof ������߶����Ƿ����ұ�������ഴ��
		System.out.println(stu1 instanceof Student916);
		System.out.println(p1 instanceof Student916); //����Ķ�����������
	}
}

class People {
	String name;
	int age;
	
	public void zouLu() {
		System.out.println("��·");
	}
	public void paoBu() {
		System.out.println("�ܲ�");
	}
}

class Student916 extends People {
	String stuid;
	
	public void xueXi() {
		System.out.println("ѧϰ");
		this.zouLu();
	}
	
	public void paoBu() {
		System.out.println("��д������ܲ�");
	}
	
	public Student916(String name,int age,String stuid) {
		//��Ϊ�̳��˸��� People��ӵ�������г�Ա����
		this.name = name;
		this.age = age;
		this.stuid = stuid;
	}
	
}