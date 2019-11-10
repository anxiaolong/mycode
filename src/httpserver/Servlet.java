package httpserver;
/**
 * 定义servlet接口
 * @author Administrator
 *
 */
public interface Servlet {
	//需要实现的方法
	public void service(Request request,Response response);
}
