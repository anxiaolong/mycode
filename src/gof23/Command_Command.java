package gof23;
/**
 * ����ӿں�ʵ����
 * @author Administrator
 *
 */
public interface Command_Command {
	void execute();
}


class ConcreteCommand implements Command_Command{
	private Command_Receiver receiver;//����ִ����
	
	public ConcreteCommand(Command_Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		//ʵ��ִ����receiver
		receiver.action();
	}
	
}