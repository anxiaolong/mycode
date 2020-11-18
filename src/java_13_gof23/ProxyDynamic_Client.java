package java_13_gof23;
/**
 * 测试动态代理
 */
import java.lang.reflect.Proxy;

public class ProxyDynamic_Client {
	public static void main(String[] args) {
		ProxyDynamic_Star realStar = new ProxyDynamic_RealStar();
		ProxyDynamic_StarHandler handler = new ProxyDynamic_StarHandler(realStar);
		
		ProxyDynamic_Star proxy = (ProxyDynamic_Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[] {ProxyDynamic_Star.class}, handler);
		
		//proxy对象没执行一个方法，就回调用一次handler的invoke方法
		//代理处理的逻辑全部放在invoke方法中
		proxy.sing();
		proxy.bookTicket();
	}
}
