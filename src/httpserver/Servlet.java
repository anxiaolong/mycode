package httpserver;
/**
 * ����servlet�ӿ�
 * @author Administrator
 *
 */
public interface Servlet {
	//��Ҫʵ�ֵķ���
	public void service(Request request,Response response);
}
