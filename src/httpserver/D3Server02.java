package httpserver;
/**
 * 封装响应response
 * 封装请求request
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
			
			//获取请求协议
			D3Request request = new D3Request(socket);
			request.parseRequestInfo();
			request.coverMap();
			//响应信息
			D3Response response = new D3Response(socket);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("这是server返回的结果：");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("响应成功了");
			response.print("</body>");
			response.print("</html>");
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
