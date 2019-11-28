package gof23;
/**
 * 动态代理类
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDynamic_StarHandler implements InvocationHandler {
	ProxyDynamic_Star realStar;
	
	public ProxyDynamic_StarHandler(ProxyDynamic_Star realStar) {
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		
		System.out.println("真正方法执行前");
		System.out.println("面谈，签合同，预付款，订机票");
		
		if (method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		} else {
			System.out.println("ProxyStart负责执行相关操作");
		}
		
		System.out.println("真正的方法执行后");
		System.out.println("收尾款");
		System.out.println("#############################");
		
		return object;
	}
	
	

}
