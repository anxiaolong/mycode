package java_13_gof23;
/**
 * ²âÊÔÃüÁîÄ£Ê½
 * @author Administrator
 *
 */
public class Command_Client {
	public static void main(String[] args) {
		Command_Command c = new ConcreteCommand(new Command_Receiver());
		Command_Invoke i = new Command_Invoke(c);
		
		i.call();
	}
}
