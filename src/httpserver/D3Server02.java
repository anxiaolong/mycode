package httpserver;
/**
 * 封装响应response
 */
import java.io.IOException;
import java.io.InputStream;
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
			InputStream is = socket.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
			
			//响应信息
			D3Response response = new D3Response(socket);
			response.print("这是server返回的结果");
			response.pushToBrowser(200);
			System.out.println(response.headInfo);
			System.out.println(response.content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端异常");
		}
	}
	
	public void stop() {
		
	}
}
