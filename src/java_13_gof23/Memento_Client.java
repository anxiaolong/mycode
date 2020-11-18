package java_13_gof23;
/**
 * 测试备忘录模式
 * @author Administrator
 *
 */
public class Memento_Client {
	public static void main(String[] args) {
		Memento_CareTaker taker = new Memento_CareTaker();
		
		Memento_Emp emp = new Memento_Emp("刘德华", 55, 999);
		System.out.println(emp.toString());
		
		//备忘一次
		taker.setMemento(emp.memento());
		
		emp.setAge(88);
		emp.setEname("周杰伦");
		emp.setSalary(333);
		
		System.out.println(emp.toString());
		
		//恢复备忘状态
		emp.recovery(taker.getMemento());
		
		System.out.println(emp.toString());
	}
}
