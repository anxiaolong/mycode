package gof23;
/**
 * ������ʵ����
 * @author Administrator
 *
 */
public class Command_Invoke {
	private Command_Command command;
	
	public Command_Invoke(Command_Command command) {
		this.command = command;
	}
	
	//ҵ�񷽷������ڵ���������ķ���
	public void call() {
		command.execute();
	}
}
