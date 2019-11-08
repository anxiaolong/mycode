package httpserver;
/**
 * 引入servlet
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class D3Server02 {
private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		D3Server02 server = new D3Server02();
		server.start();
	}
	
	public void start() {
		//新建一个ServerSocket对象
		try {
			serverSocket = new ServerSocket(9001);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("启动失败");
		}
	}
	
	public void receive() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("一个连接进来");
			
			//获取请求
			D3Request request = new D3Request(socket);
			
			//通过请求参数创建servlet
			D3Servlet servlet = null;
			if (request.getUrl().equals("/login")) {
				servlet = new D3LoginServlet();
			} else if (request.getUrl().equals("/reg")) {
				servlet = new D3RegisterServlet();
			}
			//创建响应对象
			D3Response response = new D3Response(socket);
			//向servlet传入请求和响应对象
			servlet.service(request, response);
			//关注状态码
			response.pushToBrowser(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端异常");
		}
	}
	
	public void stop() {
		
	}
}
