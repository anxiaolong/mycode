package gof23;
/**
 * ���Ծ�̬����ģʽ
 * @author Administrator
 *
 */
public class ProxyStatic_Client {
	public static void main(String[] args) {
		ProxyStatic_RealStar realstar = new ProxyStatic_RealStar();
		ProxyStatic_ProxyStar proxyStar = new ProxyStatic_ProxyStar(realstar);
		
		proxyStar.signContract();
		proxyStar.sing();
		proxyStar.collectMoney();
	}
}
