package java_13_gof23;
/**
 * ���Զ�̬����
 */
import java.lang.reflect.Proxy;

public class ProxyDynamic_Client {
	public static void main(String[] args) {
		ProxyDynamic_Star realStar = new ProxyDynamic_RealStar();
		ProxyDynamic_StarHandler handler = new ProxyDynamic_StarHandler(realStar);
		
		ProxyDynamic_Star proxy = (ProxyDynamic_Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] {ProxyDynamic_Star.class}, handler);
		
		//proxy����ûִ��һ���������ͻص���һ��handler��invoke����
		//��������߼�ȫ������invoke������
		proxy.sing();
		proxy.bookTicket();
	}
}
