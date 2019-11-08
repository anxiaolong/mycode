package httpserver;
/**
 * 定义servlet接口
 * @author Administrator
 *
 */
public interface D3Servlet {
	//需要实现的方法
	public void service(D3Request request,D3Response response);
}
