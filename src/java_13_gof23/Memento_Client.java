package java_13_gof23;
/**
 * ���Ա���¼ģʽ
 * @author Administrator
 *
 */
public class Memento_Client {
	public static void main(String[] args) {
		Memento_CareTaker taker = new Memento_CareTaker();
		
		Memento_Emp emp = new Memento_Emp("���»�", 55, 999);
		System.out.println(emp.toString());
		
		//����һ��
		taker.setMemento(emp.memento());
		
		emp.setAge(88);
		emp.setEname("�ܽ���");
		emp.setSalary(333);
		
		System.out.println(emp.toString());
		
		//�ָ�����״̬
		emp.recovery(taker.getMemento());
		
		System.out.println(emp.toString());
	}
}
