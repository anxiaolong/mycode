package oop;
/**
 * Ȩ�޹ؼ���      ����      ����       ����������     ������������
 * private     1      0         0           0
 * default     1      1         0           0
 * protected   1      1         1           0
 * public      1       1         1          1
 * Ȩ�޹ؼ��ֶԷ����ͳ�Ա����������
 * ����get��set
 * @author Administrator
 *
 */

public class TestFZ {
	public static void main(String[] args) {
		TestFZ1 t1Fz1 = new TestFZ1();
		TestFZ1 t1Fz2 = new TestFZ1();
//		System.out.println(t1Fz1.name); //����ֱ�ӷ���˽������
		t1Fz1.setAge(-12); //ͨ��set���Ƕ�������ֵ
		System.out.println(t1Fz1.getAge()); //ͨ��get��ȡ��������ֵ
		System.out.println(t1Fz1.isSex()); //�������͵Ļ�ȡʹ��is����get
	}
}

class TestFZ1 {
	private String name;
	private int age;
	private boolean sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		//set�����ĺô��ǣ�������������ò���������
		if (age>130||age<0) {
			System.out.println("�������С��130������"); 
		} else {
			this.age = age;
		}
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
}