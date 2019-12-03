package gof23;
/**
 * 调用者实体类
 * @author Administrator
 *
 */
public class Command_Invoke {
	private Command_Command command;
	
	public Command_Invoke(Command_Command command) {
		this.command = command;
	}
	
	//业务方法，用于调用命令类的方法
	public void call() {
		command.execute();
	}
}
