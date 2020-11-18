package java_13_gof23;
/**
 * 负责具体的策略类交互
 * @author Administrator
 *
 */
public class Strategy_Context {
	//持有算法对象
	private Strategy_Strategy strategy;
	
	public Strategy_Context(Strategy_Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void pringPrice(double s) {
		System.out.println("您该报价："+strategy.getPrice(s));
	}
}
