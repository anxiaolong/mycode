package java_13_gof23;
/**
 * �������Ĳ����ཻ��
 * @author Administrator
 *
 */
public class Strategy_Context {
	//�����㷨����
	private Strategy_Strategy strategy;
	
	public Strategy_Context(Strategy_Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void pringPrice(double s) {
		System.out.println("���ñ��ۣ�"+strategy.getPrice(s));
	}
}
