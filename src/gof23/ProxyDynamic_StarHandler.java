package gof23;
/**
 * ��̬������
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
		
		System.out.println("��������ִ��ǰ");
		System.out.println("��̸��ǩ��ͬ��Ԥ�������Ʊ");
		
		if (method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		} else {
			System.out.println("ProxyStart����ִ����ز���");
		}
		
		System.out.println("�����ķ���ִ�к�");
		System.out.println("��β��");
		System.out.println("#############################");
		
		return object;
	}
	
	

}
