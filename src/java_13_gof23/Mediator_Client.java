package java_13_gof23;
/**
 * �����н���ģʽ
 * @author Administrator
 *
 */
public class Mediator_Client {
	public static void main(String[] args) {
		Mediator_Mediator m =  new President();
		
		Market market =  new Market(m);
		Development devp = new Development(m);
		Finacial f = new Finacial(m);
		
		market.selfAction();
		market.outAction();
	}
	
}
