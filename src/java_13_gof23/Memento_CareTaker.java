package java_13_gof23;
/**
 * 负责人类
 * 负责管理备忘录对象
 * @author Administrator
 *
 */
public class Memento_CareTaker {
	private Memento_EmpMemento memento;

	public Memento_EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(Memento_EmpMemento memento) {
		this.memento = memento;
	}

}
