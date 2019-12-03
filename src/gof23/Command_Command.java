package gof23;
/**
 * 命令接口和实体类
 * @author Administrator
 *
 */
public interface Command_Command {
	void execute();
}


class ConcreteCommand implements Command_Command{
	private Command_Receiver receiver;//命令执行者
	
	public ConcreteCommand(Command_Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		//实际执行是receiver
		receiver.action();
	}
	
}